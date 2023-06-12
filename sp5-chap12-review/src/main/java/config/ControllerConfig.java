package config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import controller.RegisterController;
import spring.MemberRegisterService;

@Configuration
public class ControllerConfig {
	
	@Bean
	public RegisterController registerController(MemberRegisterService memberRegisterService) {
		RegisterController registerController = new RegisterController();
		registerController.setMemberRegisterService(memberRegisterService);
		return registerController;
	}
}
