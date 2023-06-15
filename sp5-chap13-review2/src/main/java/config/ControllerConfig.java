package config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import controller.LoginController;
import controller.RegisterController;
import spring.AuthService;
import spring.MemberRegisterService;

@Configuration
public class ControllerConfig {
	
	@Autowired
	private AuthService authService;
	
	@Bean
	public RegisterController registerController(
			@Qualifier("memberRegSvc") MemberRegisterService memberRegisterService) {
		RegisterController controller = new RegisterController();
		controller.setMemberRegisterService(memberRegisterService);
		return controller;
	}
	
	@Bean
	public LoginController loginController() {
		LoginController loginController = new LoginController();
		loginController.setAuthService(authService);
		return loginController;
	}
}
