package spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import spring.dao.MemberDao;
import spring.domain.Member;
import spring.exception.MemberNotFoundException;

@Component
public class ChangePasswordService {

	private MemberDao memberDao;

	@Autowired
	public ChangePasswordService(MemberDao memberDao) {
		this.memberDao = memberDao;
	}
	
	public ChangePasswordService() {}

	public void changePassword(String email, String oldPwd, String newPwd) {
		Member member = memberDao.selectByEmail(email);
		
		// 가입된 회원이 없는 경우 : 예회 발생
		if(member == null) {
			throw new MemberNotFoundException();
		}
		
		// 가입된 회원이 있는 경우 : update메소드 실행
		member.changedPassword(oldPwd, newPwd); // 비밀번호 일치 여부 확인 후 비밀번호 변경
		memberDao.update(member); // 수정 처리
	}
}
