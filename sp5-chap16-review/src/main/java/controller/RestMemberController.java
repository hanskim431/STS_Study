package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import spring.Member;
import spring.MemberDao;

@RestController
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
	public Member member (Long id, HttpServletResponse response) throws IOException {
		Member member = memberDao.selectById(id);
		if(member==null) {
			response.sendError(HttpServletResponse.SC_NOT_FOUND);
			return member;
		}
		return null;
	}
	
}