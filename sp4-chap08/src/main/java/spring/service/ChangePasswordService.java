package spring.service;

import org.springframework.transaction.annotation.Transactional;

import lombok.Setter;
import spring.dao.Member;
import spring.dao.MemberDao;
import spring.exception.MemberNotFoundException;

@Setter
public class ChangePasswordService {

	private MemberDao memberDao;
	
	@Transactional // 두번의 변경이 일어나지 않지만 sql 문 두번 일어났기 떄문에 붙여도 무방하다.
	public void changePassword(String email, String curPwd, String newPwd) {
		Member findMember = memberDao.selectByEmail(email);
		if (findMember==null) {
			throw new MemberNotFoundException();
		}
		findMember.changePassword(curPwd,newPwd);
		memberDao.update(findMember);
		
	}

}
