package spring.service;

import spring.dao.IMemberDao;

public class ChangePasswordService {

	private IMemberDao memberDao;

	// ������ ����(injection)
		public ChangePasswordService(IMemberDao memberDao) { // MemberDao(dependency)
			this.memberDao = memberDao; 
		}
	
	public void changePwd() {
		memberDao.update();
	}
}
