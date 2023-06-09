package main;

import assembler.Assembler;
import spring.dao.MemberDao;
import spring.dao.MemberDao2;
import spring.service.ChangePasswordService;
import spring.service.MemberRegisterService;

public class Main {

	public static void main(String[] args) {
		Assembler assembler = new Assembler();
		
		MemberRegisterService memberRegisterService = assembler.getMemberRegisterService();
		ChangePasswordService changePasswordService = assembler.getChangePasswordService();

		memberRegisterService.register();
		changePasswordService.changePwd();
	}
}
