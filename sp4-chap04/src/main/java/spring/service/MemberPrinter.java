package spring.service;

import spring.domain.Member;

public class MemberPrinter {

	public void print(Member member) {
		System.out.printf("ȸ�� ���� : ���̵�=%d, �̸���=%s, �̸�=%s, �����=%tF \n",
				member.getId(), member.getEmail(), member.getName(), member.getRegisterDate());
		
	}
}
