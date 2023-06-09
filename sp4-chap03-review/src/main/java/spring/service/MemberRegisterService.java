package spring.service;

import spring.dao.IMemberDao;

public class MemberRegisterService  {

	private IMemberDao memberDao;
	
	// 수정자 메소드(setter) 주입
	public void setMemberDao(IMemberDao memberDao) {
		this.memberDao = memberDao;
	}
	
	public void register () {
		memberDao.insert();
	}
	
}
