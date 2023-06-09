package config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import dao.MemberDao;
import service.MemberService;

@Configuration
public class MemberConfig {
	
	@Autowired
	DataSource dataSource;
	
	@Bean
	public MemberDao memberDao() {
		return new MemberDao(dataSource);
	}
	
	@Bean
	public MemberService memberService() {
		return new MemberService(memberDao());
	}
}
