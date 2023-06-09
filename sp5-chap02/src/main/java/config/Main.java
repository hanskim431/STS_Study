package config;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

import chap02.Greeter;

public class Main {

	public static void main(String[] args) {
		ApplicationContext ctx = new AnnotationConfigApplicationContext(AppContext.class);
		
		Greeter g1 = ctx.getBean("greeter",Greeter.class); // xml���� @Bean���� ���� �����ذ� ����
		String msg = g1.greet("������");
		System.out.println(msg);
		
		Greeter g2 = ctx.getBean("greeter",Greeter.class); // xml���� @Bean���� ���� �����ذ� ����
		System.out.println(g1 == g2);
	}
}
