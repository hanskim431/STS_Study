package chap02;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class Main3 {
	public static void main(String[] args) {
		ApplicationContext ctx = new GenericXmlApplicationContext("classpath:applicationContext.xml");
		
		// �̸����� �� �������� : �̸����� �������� Object Ÿ������ ������ -> ��������ȯ�� �ʿ�
		Greeter bean = (Greeter) ctx.getBean("greeter");
//		Object bean2 = ctx.getBean("greeter");
		
		// �̸��� ���� ��� : NoSuchBeanDefinitionException ���� �߻�
//		ctx.getBean("test");
	}
}
