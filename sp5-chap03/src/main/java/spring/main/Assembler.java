package spring.main;

import spring.dao.MemberDao;
import spring.service.ChangePasswordService;
import spring.service.MemberRegisterService;

// 객체 생성 및 초기화(의존 관계 정의)
public class Assembler {
	private MemberDao memberDao;
	private MemberRegisterService memberRegisterService;
	private ChangePasswordService changePasswordService;
	
	public Assembler() {
		memberDao = new MemberDao();
		memberRegisterService = new MemberRegisterService(memberDao);
		changePasswordService = new ChangePasswordService(memberDao); 
	}

	public MemberDao getMemberDao() {
		return memberDao;
	}

	public MemberRegisterService getMemberRegisterService() {
		return memberRegisterService;
	}

	public ChangePasswordService getChangePasswordService() {
		return changePasswordService;
	}
	
	
}
