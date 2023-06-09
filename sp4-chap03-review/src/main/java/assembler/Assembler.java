package assembler;

import spring.dao.IMemberDao;
import spring.dao.MemberDao;
import spring.dao.MemberDao2;
import spring.service.ChangePasswordService;
import spring.service.MemberRegisterService;

// ��ü���� �� �������� ����
public class Assembler {

	private IMemberDao memberDao;
	private MemberRegisterService memberRegisterService;
	private ChangePasswordService changePasswordService;
	
	public Assembler() {
		memberDao = new MemberDao();
		memberRegisterService = new MemberRegisterService();
		memberRegisterService.setMemberDao(memberDao);
		
		changePasswordService = new ChangePasswordService(memberDao);
	}

	public IMemberDao getMemberDao() {
		return memberDao;
	}

	public MemberRegisterService getMemberRegisterService() {
		return memberRegisterService;
	}

	public ChangePasswordService getChangePasswordService() {
		return changePasswordService;
	}
	
}
