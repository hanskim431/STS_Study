package main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import config.Conf1;
import config.Conf2;
import spring.service.MemberRegisterService;

public class MainForSpringJava2 {

	public static void main(String[] args) {
//		ApplicationContext ctx = new AnnotationConfigApplicationContext(Conf1.class, Conf2.class);
		ApplicationContext ctx = new AnnotationConfigApplicationContext(Conf1.class);
		
		MemberRegisterService bean = ctx.getBean(MemberRegisterService.class);
		bean.register();
	}
}
