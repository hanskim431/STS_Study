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
//@Controller
//@ResponseBody
public class RestMemberController {

	private MemberDao memberDao;
	private MemberRegisterService memberRegisterService;
	
	public void setMemberRegisterService(MemberRegisterService memberRegisterService) {
		this.memberRegisterService = memberRegisterService;
	}
	
	public void setMemberDao(MemberDao memberDao) {
		this.memberDao = memberDao;
	}
	
	@GetMapping("/api/members")
	public List<Member> members() {
		return memberDao.selectAll();
	}
	
	@GetMapping("/api/members/{id}")
	public Member member(@PathVariable("id") Long id, HttpServletResponse response) throws IOException {
		Member member = memberDao.selectById(id);
		if(member==null) {
			// 404 응답 코드
			response.sendError(HttpServletResponse.SC_NOT_FOUND);
			return null;
		}
		return member;
	}
	
	@GetMapping("/api/demo")
	public DemoBean demoTest() {
		DemoBean demoBean = new DemoBean();
		demoBean.setRegDate(new Date()); // 70년부터 ms 단위
		return demoBean;
	}
	
	@PostMapping("/api/members")
	public void newMember(@RequestBody RegisterRequest registerRequest, HttpServletResponse response) throws IOException {
		try {
			Long newMemberId = memberRegisterService.regist(registerRequest);
			response.setStatus(HttpServletResponse.SC_CREATED);
			response.setHeader("Location", "/api/members"+newMemberId);
		} catch (Exception e) {
			response.sendError(HttpServletResponse.SC_CONFLICT);
		}
	}
}
