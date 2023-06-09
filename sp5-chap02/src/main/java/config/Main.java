package config;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

import chap02.Greeter;

public class Main {

	public static void main(String[] args) {
		ApplicationContext ctx = new AnnotationConfigApplicationContext(AppContext.class);
		
		Greeter g1 = ctx.getBean("greeter",Greeter.class); // xml보다 @Bean에서 네임 정해준게 무선
		String msg = g1.greet("스프링");
		System.out.println(msg);
		
		Greeter g2 = ctx.getBean("greeter",Greeter.class); // xml보다 @Bean에서 네임 정해준게 무선
		System.out.println(g1 == g2);
	}
}
