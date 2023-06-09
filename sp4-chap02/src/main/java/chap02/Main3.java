package chap02;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class Main3 {
	public static void main(String[] args) {
		ApplicationContext ctx = new GenericXmlApplicationContext("classpath:applicationContext.xml");
		
		// 이름으로 빈 가져오기 : 이름으로 가져오면 Object 타입으로 가져옴 -> 강제형변환이 필요
		Greeter bean = (Greeter) ctx.getBean("greeter");
//		Object bean2 = ctx.getBean("greeter");
		
		// 이름이 없는 경우 : NoSuchBeanDefinitionException 예외 발생
//		ctx.getBean("test");
	}
}
