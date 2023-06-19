package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import spring.Member;
import spring.MemberDao;

@RestController
//@Controller
//@ResponseBody
public class RestMemberController {

	private MemberDao memberDao;

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
			response.sendError(404);
		}
		return member;
	}
}
