package example.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import example.dao.MemberDao;

@Configuration // 스프링 설정 정보이다 라는것을 알려주는 태그
public class ExamConfig {
	
	// mdao를 스프링 필드로 등록하려 함
	// 메소드를 사용하면  됨 
	// 메소드 이름은 bean의 이름
//	@Bean(name = "memberDAO") 
//	@Bean("memberDAO") =  (value = "memberDAO")
//	@Bean(value = "memberDAO") //bean id 재지정 name == value [생략 가능] => ("이름")
	@Bean({"memberDAO", "mdao"}) 
	public MemberDao memberDao () {
		MemberDao dao = new MemberDao();
		dao.setDataSource("오라클");
		return dao;
	}

	@Bean
	@Scope("prototype") // 프로토타입으로 요청
	public MemberDao memberDao2 () {
		MemberDao dao = new MemberDao();
		dao.setDataSource("마리아DB");
		return dao;
	}
}
