package chap02;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class Main4 {
	public static void main(String[] args) {
		ApplicationContext ctx = new GenericXmlApplicationContext("classpath:applicationContext.xml");
		
		// Ÿ������ �� ��������
		// ��, ���� ���Ͽ� ���� Ÿ���� ���� 2�� �̻� ���ǵǾ� ���� �� ���� �߻� : NoUniqueBeanDefinitionException
		Greeter g = ctx.getBean(Greeter.class);
		String greet = g.greet("spring");
		System.out.println(greet);
	}
}
