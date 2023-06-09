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
		
		// ���Ե� ȸ���� ���� ��� : ��ȸ �߻�
		if(member == null) {
			throw new MemberNotFoundException();
		}
		
		// ���Ե� ȸ���� �ִ� ��� : update�޼ҵ� ����
		member.changedPassword(oldPwd, newPwd); // ��й�ȣ ��ġ ���� Ȯ�� �� ��й�ȣ ����
		memberDao.update(member); // ���� ó��
	}
}
