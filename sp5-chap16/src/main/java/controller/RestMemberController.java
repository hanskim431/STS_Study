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
	
	public void setMemberDao(MemberDao memberDao) {
		this.memberDao = memberDao;
	}
	
	public void setMemberRegisterService(MemberRegisterService memberRegisterService) {
		this.memberRegisterService = memberRegisterService;
	}
	
	@GetMapping("/api/members")
	public List<Member> members() {
		return memberDao.selectAll();
	}
	
	// id로 멤버 찾기
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


/*
	JSON 응답과 요청 처리
	토픽 : 
	
	JSON = 메시지 전송 형식
	- GOOD : 데이터 구조 유연(DB 수정 X), 복잡한 데이터 처리, 확장성과 호환성(다양한 프로그래밍 언어)
	- BAD : 성능, 쿼리 제한, 데이터 무결성 유지
	
	 Jackson = JAVA 객체와 JSON간의 상호 변환용 JAVA 라이브러리
	- 
	- 
	
	@RestController = @Controller + @ResponseBody (after sp4)
	
	@JsonIgnore = 제외 처리 (password 등)
	
	@JsonFormat(shape=Shape.STRING), @JsonFormat(pattern="yyyy년MM월dd일 HH시mm분ss초") = 날짜 형식 변환
	서버 API
*/