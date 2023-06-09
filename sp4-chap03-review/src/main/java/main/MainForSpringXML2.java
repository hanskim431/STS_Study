package main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import spring.service.MemberRegisterService;

public class MainForSpringXML2 {

	public static void main(String[] args) {
		ApplicationContext ctx = null;
//		ctx = new GenericXmlApplicationContext("classpath:spring-config/conf1.xml","classpath:spring-config/conf2.xml");
//		ctx = new GenericXmlApplicationContext(new String[] {"classpath:spring-config/conf1.xml","classpath:spring-config/conf2.xml"});
		ctx = new GenericXmlApplicationContext("classpath:spring-config/conf1.xml");
		
		MemberRegisterService memberRegisterService = ctx.getBean(MemberRegisterService.class);
		memberRegisterService.register();
	}
}
