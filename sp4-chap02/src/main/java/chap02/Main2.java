package chap02;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class Main2 {
	public static void main(String[] args) {
		// 직접 생성
		Greeter g1 = new Greeter();
		Greeter g2 = new Greeter();
		
		// g1과 g2는 서로 다른 객체
		System.out.println("g1==g2 : " + (g1==g2));
		System.out.println("g1.equals(g2) : " + g1.equals(g2)); // false
		
		ApplicationContext ctx = new GenericXmlApplicationContext("classpath:applicationContext.xml");

		// 스프링 컨테이너에서 빈을 가져옴 : 같은 객체
		Greeter g3 = ctx.getBean("greeter",Greeter.class);
		Greeter g4 = ctx.getBean("greeter",Greeter.class);
		
		System.out.println("g3==g4: " + (g3==g4));
		System.out.println("g3.equals(g4) : " + g3.equals(g4)); // false

		
	}
}
