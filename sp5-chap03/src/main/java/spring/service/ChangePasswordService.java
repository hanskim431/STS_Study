package spring.service;

import spring.dao.MemberDao;
import spring.domain.Member;
import spring.exception.MemberNotFoundException;

public class ChangePasswordService {

	private MemberDao memberDao;

	public ChangePasswordService(MemberDao memberDao) {
		this.memberDao = memberDao;
	}
	
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
