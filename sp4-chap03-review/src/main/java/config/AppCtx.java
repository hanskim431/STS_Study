package config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import spring.dao.MemberDao;
import spring.dao.MemberDao2;
import spring.service.ChangePasswordService;
import spring.service.MemberRegisterService;
import spring.service.ServiceVersion;

@Configuration
public class AppCtx {
	
	@Bean
	public MemberDao memberDao() { // public (name, 생성할 타입) (id, 스프링빈 이름)
		return new MemberDao();
	}
	
	@Bean
	public MemberDao2 memberDao2() {
		return new MemberDao2();
	}

	@Bean
	@Scope("prototype")
	public MemberRegisterService memberRegisterService() {
		MemberRegisterService service = new MemberRegisterService();
		service.setMemberDao(memberDao());
		return service;
	}
	
	@Bean
	public ChangePasswordService changePasswordService() {
		return new ChangePasswordService(memberDao());
	}
	
	@Bean
	public ServiceVersion serviceVersion() {
		ServiceVersion version = new ServiceVersion();
		version.setMajor("4");
		version.setMinor(3);
		return version;
	}

	@Bean
	public ServiceVersion serviceVersion2() {
		return new ServiceVersion("5", 2);
	}
}
