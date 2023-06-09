package config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import common.CommonExceptionHandler;
import controller.ChangePwdController;
import controller.LoginController;
import controller.LogoutController;
import controller.MemberDetailController;
import controller.MemberListController;
import controller.RegisterController;
import controller.RestMemberController;
import spring.AuthService;
import spring.ChangePasswordService;
import spring.MemberDao;
import spring.MemberRegisterService;

@Configuration
public class ControllerConfig {
	
	@Autowired
	private AuthService authService;
	
	@Autowired
	private ChangePasswordService changePasswordService;
	
	@Bean
	public RegisterController registerController(
			@Qualifier("memberRegSvc") MemberRegisterService memberRegisterService) {
		RegisterController controller = new RegisterController();
		controller.setMemberRegisterService(memberRegisterService);
		return controller;
	}
	
	@Bean
	public LoginController loginController() {
		LoginController controller = new LoginController();
		controller.setAuthService(authService);
		return controller;
	}
	
	@Bean
	public LogoutController logoutController() {
		return new LogoutController();
	}
	
	@Bean
	public ChangePwdController changePwdController() {
		ChangePwdController controller = new ChangePwdController();
		controller.setChangePasswordService(changePasswordService);
		return controller;
	}
	
	@Bean
	public MemberListController memberListController(MemberDao memberDao) {
		MemberListController controller = new MemberListController();
		controller.setMemberDao(memberDao);
		return controller;
	}
	
	@Bean
	public MemberDetailController memberDetailController(MemberDao memberDao) {
		MemberDetailController controller = new MemberDetailController();
		controller.setMemberDao(memberDao);
		return controller;
	}
	
	@Bean
	public CommonExceptionHandler commonExceptionHandler() {
		return new CommonExceptionHandler(); 
	}
	
	@Bean
	public RestMemberController restMemberController(MemberDao memberDao, MemberRegisterService memberRegisterService) {
		RestMemberController controller = new RestMemberController();
		controller.setMemberDao(memberDao);
		controller.setRegisterService(memberRegisterService);
		return controller;
	}
}
