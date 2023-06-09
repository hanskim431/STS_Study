package spring.service;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class MemberInfoPrinterTest {

	@Test
	public void test() {
		ApplicationContext ctx = new GenericXmlApplicationContext("classpath:appCtx.xml");
		MemberInfoPrinter memberInfoPrinter = ctx.getBean(MemberInfoPrinter.class);
		memberInfoPrinter.printMemberInfo("go@test.com");
		memberInfoPrinter.printMemberInfo("gone@test.com");
	}
}
