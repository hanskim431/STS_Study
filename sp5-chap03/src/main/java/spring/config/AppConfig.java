package spring.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import spring.dao.MemberDao;
import spring.service.ChangePasswordService;
import spring.service.MemberRegisterService;

@Configuration // 스프링이 설정 정보로 사용하는 구성(Configuration)클래스
public class AppConfig {
	
	@Bean
	public MemberDao memberDao() {
		return new MemberDao();
	}
	
	@Bean
	public MemberRegisterService memberRegisterService() {
		return new MemberRegisterService(memberDao());
	}
	
	@Bean
	public ChangePasswordService changePasswordService() {
		return new ChangePasswordService(memberDao());
	}
}
