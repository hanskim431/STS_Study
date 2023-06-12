package chap02;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class Main {
	public static void main(String[] args) {
		// String.format ���ڿ��� ������ : printf�� �ٸ� ���� ���ϰ��� �ְ�, �ܼ� ����� ���� ����
//		String msg = String.format("�ȳ��ϼ���, %s �� %d + %d �� �����Դϱ�?", "ȫ�浿", 2, 3);
//		System.out.println(msg);
		
//		Greeter greeter = new Greeter(); // ��ü ����
//		greeter.setFormat("%s��, �ȳ��ϼ���"); // �ʱ�ȭ. set
//		
//		String msg = greeter.greet("������");
//		
//		System.out.println(msg);

		
		// ApplicationContext : ������ �����̳��� �������̽�
		// GenericXmlApplicationContext : XML ���� ������ �д� ������ �����̳��� ����ü
		// applicationContext.xml : ������ ���� ���� (������ ���� ����, �ʱ�ȭ)
		
		ApplicationContext ctx = new GenericXmlApplicationContext("classpath:applicationContext.xml"); 
		// applicationContext.xml�� ���� ������ �о�(GenericXmlApplicationContext)�� ������ ���� ���� ctx �� �����Ѵ�.(ApplicationContext)
		// ������ �����̳� ����
		
		// ctx.getBean(param1, param2);
		// param1 : ������ ���� �̸� (bean �±׿���  id�� ������ ��)
		// param2 : ������ ���� Ÿ�� 
		Greeter g = ctx.getBean("greeter", Greeter.class); // 
		String msg = g.greet("������");
		
		// �̸��� test �� ������ ���� �����ϴ°�?
		System.out.println(ctx.containsBean("test"));
		System.out.println(ctx.containsBean("greeter"));
		System.out.println();
		
		// greeter ���� �̱��� ���ΰ�? 
		System.out.println(ctx.isSingleton("greeter")); // ���������� �̱������� ������
		
		System.out.println(msg);
		
		
	}
}