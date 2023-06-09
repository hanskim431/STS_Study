package example.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import example.dao.MemberDao;

@Configuration // ������ ���� �����̴� ��°��� �˷��ִ� �±�
public class ExamConfig {
	
	// mdao�� ������ �ʵ�� ����Ϸ� ��
	// �޼ҵ带 ����ϸ�  �� 
	// �޼ҵ� �̸��� bean�� �̸�
//	@Bean(name = "memberDAO") 
//	@Bean("memberDAO") =  (value = "memberDAO")
//	@Bean(value = "memberDAO") //bean id ������ name == value [���� ����] => ("�̸�")
	@Bean({"memberDAO", "mdao"}) 
	public MemberDao memberDao () {
		MemberDao dao = new MemberDao();
		dao.setDataSource("����Ŭ");
		return dao;
	}

	@Bean
	@Scope("prototype") // ������Ÿ������ ��û
	public MemberDao memberDao2 () {
		MemberDao dao = new MemberDao();
		dao.setDataSource("������DB");
		return dao;
	}
}
