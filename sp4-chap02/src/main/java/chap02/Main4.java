package chap02;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class Main4 {
	public static void main(String[] args) {
		ApplicationContext ctx = new GenericXmlApplicationContext("classpath:applicationContext.xml");
		
		// 타입으로 빈 가져오기
		// 단, 설정 파일에 같은 타입의 빈이 2개 이상 정의되어 있을 때 오류 발생 : NoUniqueBeanDefinitionException
		Greeter g = ctx.getBean(Greeter.class);
		String greet = g.greet("spring");
		System.out.println(greet);
	}
}
