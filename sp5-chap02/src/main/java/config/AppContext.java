package config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import chap02.Greeter;

// ������(�����̳�)�� ����ϴ� �ڹ� ����(���� Contiguration) ����

@Configuration
public class AppContext { // applicationContext.xml�� ����
	
	// ������ �� ����
	// ��ȯ Ÿ�� �����ϰ��� �ϴ� ���� Ÿ��
	// ���� �̸� : �޼ҵ� �̸��� ��ġ <bean id="">
//	@Bean(name="test")
	@Bean
	public Greeter greeter() {
		Greeter g = new Greeter();
		g.setFormat("%s��, �ȳ��ϼ���");
		return g;
	}
}
