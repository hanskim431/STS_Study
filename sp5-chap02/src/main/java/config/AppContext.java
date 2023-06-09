package config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import chap02.Greeter;

// 스프링(컨테이너)이 사용하는 자바 설정(구성 Contiguration) 정보

@Configuration
public class AppContext { // applicationContext.xml의 역할
	
	// 스프링 빈 생성
	// 반환 타입 생성하고자 하는 빈의 타입
	// 빈의 이름 : 메소드 이름과 일치 <bean id="">
//	@Bean(name="test")
	@Bean
	public Greeter greeter() {
		Greeter g = new Greeter();
		g.setFormat("%s님, 안녕하세요");
		return g;
	}
}
