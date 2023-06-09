package main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import assembler.Assembler;
import spring.dao.MemberDao;
import spring.dao.MemberDao2;
import spring.service.ChangePasswordService;
import spring.service.MemberRegisterService;
import spring.service.ServiceVersion;

public class MainForSpringXML {

	public static void main(String[] args) {
		ApplicationContext ctx = new GenericXmlApplicationContext("classpath:spring-config/appCtx.xml");
		
		MemberRegisterService memberRegisterService = ctx.getBean("memberRegisterService2",MemberRegisterService.class);
		MemberRegisterService bean = (MemberRegisterService) ctx.getBean("memberRegisterService2");
		
		ChangePasswordService changePasswordService = ctx.getBean(ChangePasswordService.class);

		memberRegisterService.register();
		changePasswordService.changePwd();
		
		bean.register();
		
		System.out.println(bean==memberRegisterService);
		
		ServiceVersion serviceVersion = ctx.getBean("serviceVersion",ServiceVersion.class);
		serviceVersion.versionPrint();
		
		ServiceVersion serviceVersion2 = ctx.getBean("serviceVersion2",ServiceVersion.class);
		serviceVersion2.versionPrint();
		
	}
}
