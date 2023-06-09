package main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import assembler.Assembler;
import config.AppCtx;
import spring.dao.MemberDao;
import spring.dao.MemberDao2;
import spring.service.ChangePasswordService;
import spring.service.MemberRegisterService;
import spring.service.ServiceVersion;

public class MainForSpringJava {

	public static void main(String[] args) {
		ApplicationContext ctx = new AnnotationConfigApplicationContext(AppCtx.class);
		
		MemberRegisterService memberRegisterService = ctx.getBean("memberRegisterService",MemberRegisterService.class);
		MemberRegisterService bean = (MemberRegisterService) ctx.getBean("memberRegisterService");
		
		ChangePasswordService changePasswordService = ctx.getBean(ChangePasswordService.class);

		memberRegisterService.register();
		changePasswordService.changePwd();
		
		bean.register();
		
		System.out.println(bean==memberRegisterService);
		
		ServiceVersion serviceVersion = ctx.getBean("serviceVersion",ServiceVersion.class);
		ServiceVersion serviceVersion2 = ctx.getBean("serviceVersion2",ServiceVersion.class);
		serviceVersion.versionPrint();
		serviceVersion2.versionPrint();
	}
}
