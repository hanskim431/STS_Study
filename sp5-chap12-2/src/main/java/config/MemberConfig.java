package config;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import spring.ChangePasswordService;
import spring.MemberDao;
import spring.MemberRegisterService;

@Configuration
@EnableTransactionManagement
public class MemberConfig {

	@Bean
	public DataSource dataSource() {
		HikariConfig config= new HikariConfig(); 
		config.setDriverClassName("org.mariadb.jdbc.Driver");
		config.setJdbcUrl("jdbc:mariadb://localhost:3306/spring5fs");
		config.setUsername("spring5fs");
		config.setPassword("1234");
		return new HikariDataSource(config); 
	}

	@Bean
	public PlatformTransactionManager transactionManager() {
		DataSourceTransactionManager tm = new DataSourceTransactionManager(); 
		tm.setDataSource(dataSource());
		return tm; 
	}
	
	@Bean
	public MemberDao memberDao() {
		return new MemberDao(dataSource());
	}

	@Bean
	public MemberRegisterService memberRegSvc() {
		return new MemberRegisterService(memberDao());
	}

	@Bean
	public ChangePasswordService changePwdSvc() {
		ChangePasswordService pwdSvc = new ChangePasswordService();
		pwdSvc.setMemberDao(memberDao());
		return pwdSvc;
	}
}
