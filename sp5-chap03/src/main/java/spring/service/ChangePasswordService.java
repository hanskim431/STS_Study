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
		
		// ���Ե� ȸ���� ���� ��� : ��ȸ �߻�
		if(member == null) {
			throw new MemberNotFoundException();
		}
		
		// ���Ե� ȸ���� �ִ� ��� : update�޼ҵ� ����
		member.changedPassword(oldPwd, newPwd); // ��й�ȣ ��ġ ���� Ȯ�� �� ��й�ȣ ����
		memberDao.update(member); // ���� ó��
	}
}
