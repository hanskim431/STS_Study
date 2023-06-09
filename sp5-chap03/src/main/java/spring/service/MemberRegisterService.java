package spring.service;

import java.util.Date;

import spring.dao.MemberDao;
import spring.domain.Member;
import spring.domain.dto.RegisterRequest;

// MemberRegisterService가 MemberDao를 사용 : 의존 관계
// 외부로부터 주입 : 생성자, 수정자 메소드
public class MemberRegisterService {

	private MemberDao memberDao;

	public MemberRegisterService(MemberDao memberDao) {
		this.memberDao = memberDao;
	}

	public void register (RegisterRequest req) {
		Member member = memberDao.selectByEmail(req.getEamil());
		if(member!=null) { // 이미 가입된 이메일이면 예외 발생
			throw new AlreadyExistingMemberException("이미 사용된 이메일입니다. : " + req.getEamil());
		}
		
		// 가입되지 않은 이메일이면 insert() 메서드 실행
		Member newMember = new Member(req.getEamil(), req.getPassword(), req.getName());
		newMember.setRegisterDate(new Date());
		memberDao.insert(newMember);
		
	
	}
}
