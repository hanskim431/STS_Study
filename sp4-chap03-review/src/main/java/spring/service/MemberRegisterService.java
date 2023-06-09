package spring.service;

import spring.dao.IMemberDao;

public class MemberRegisterService  {

	private IMemberDao memberDao;
	
	// ������ �޼ҵ�(setter) ����
	public void setMemberDao(IMemberDao memberDao) {
		this.memberDao = memberDao;
	}
	
	public void register () {
		memberDao.insert();
	}
	
}
