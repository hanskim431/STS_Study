package sample;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.GenericXmlApplicationContext;

public class SampleMain2 {

	public static void main(String[] args) {
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext("classpath:sample/member-config.xml");
		MemberService memberService = ctx.getBean(MemberService.class);
		memberService.info();
		
	}
}
