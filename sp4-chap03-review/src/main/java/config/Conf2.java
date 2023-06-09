package config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import spring.dao.MemberDao;
import spring.service.MemberRegisterService;

@Configuration
public class Conf2 {

	private MemberDao memberDao;

	@Autowired // ������ �����̳ʿ� �����ϴ� MemberDaoŸ���� ���� �ڵ�����
	// MemberDaoŸ�� �� �˻� : memberDao, memberDao2
	// �̸��� MemberDao�� ���� ������ �ش� ���� ���
	// ������ ���� �߻�
	//	@Qualifier("memberDao1")
	public void setMemberDao(MemberDao memberDao) {
		System.out.println("���� �޼ҵ� ����?");
		this.memberDao = memberDao;
	}

	@Bean
	public MemberRegisterService memberRegisterService() {
		MemberRegisterService memberRegisterService = new MemberRegisterService();
		memberRegisterService.setMemberDao(memberDao);
		return memberRegisterService;
	}
}
