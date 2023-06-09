package config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import spring.dao.MemberDao;

@Configuration
@Import({Conf2.class, Conf3.class})
public class Conf1 {

	@Bean
	public MemberDao memberDao() {
		return new MemberDao();
	}
	
	@Bean
	public MemberDao memberDao2() {
		return new MemberDao();
	}
}
