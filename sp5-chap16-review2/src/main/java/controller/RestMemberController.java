package controller;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import spring.DemoBean;
import spring.Member;
import spring.MemberDao;
import spring.MemberRegisterService;
import spring.RegisterRequest;

@RestController
public class RestMemberController {

	private MemberDao memberDao;
	private MemberRegisterService registerService;

	public void setMemberDao(MemberDao memberDao) {
		this.memberDao = memberDao;
	}

	public void setRegisterService(MemberRegisterService registerService) {
		this.registerService = registerService;
	}
	
	@GetMapping("/api/members")
	public List<Member> members() {
		return memberDao.selectAll();
	}
	
	@GetMapping("/api/members/{id}")
	public Member member(@PathVariable Long id, HttpServletResponse response) throws IOException {
		Member member  = memberDao.selectById(id);
		if(member==null) {
			response.sendError(HttpServletResponse.SC_NOT_FOUND); // 404오류 응답
			return null; 
		}
		return member;
	}
	
	@PostMapping("/api/members")
	public void newMember(@RequestBody RegisterRequest registerRequest, 
					HttpServletResponse response) throws IOException {
		try {
			Long newMemberId = registerService.regist(registerRequest);
			response.setHeader("Location", "/api/members/"+newMemberId);
			response.setStatus(HttpServletResponse.SC_CREATED); // 새로운 리소스를 생성함
		} catch (Exception e) {
			// 해당 리소스가 존재하여 처리할 수 없음
			response.sendError(HttpServletResponse.SC_CONFLICT); 
		}
	}
	
	@GetMapping("/api/demo")
	public DemoBean demoTest() {
		DemoBean demoBean = new DemoBean(); 
		demoBean.setRegDate(new Date());
		return demoBean; 
	}
	
	@PostMapping("/api/demo")
	public void jsonToDate(@RequestBody DemoBean demoBean) {
		System.out.println(demoBean.getRegDate());
		System.out.println(demoBean.getUpdateDate());
	}
}