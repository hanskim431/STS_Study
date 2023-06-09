package spring.service;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class MemberListPrinterTest {

	@Test
	public void test() {
		ApplicationContext ctx = new GenericXmlApplicationContext("classpath:appCtx.xml");
		MemberListPrinter memberListPrinter = ctx.getBean(MemberListPrinter.class);
		memberListPrinter.printAll();
	}

}
