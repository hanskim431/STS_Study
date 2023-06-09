package config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import spring.dao.MemberDao;
import spring.service.MemberRegisterService;

@Configuration
public class Conf2 {

	private MemberDao memberDao;

	@Autowired // 스프링 컨테이너에 존재하는 MemberDao타입의 빈을 자동주입
	// MemberDao타입 빈 검색 : memberDao, memberDao2
	// 이름이 MemberDao인 빈이 있으면 해당 빈을 사용
	// 없으면 예외 발생
	//	@Qualifier("memberDao1")
	public void setMemberDao(MemberDao memberDao) {
		System.out.println("세터 메소드 실행?");
		this.memberDao = memberDao;
	}

	@Bean
	public MemberRegisterService memberRegisterService() {
		MemberRegisterService memberRegisterService = new MemberRegisterService();
		memberRegisterService.setMemberDao(memberDao);
		return memberRegisterService;
	}
}
