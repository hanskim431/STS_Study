package spring.domain;

import static org.junit.Assert.*;

import org.junit.Test;

import spring.exception.IdPasswordNotMatchException;

public class MemberTest {

	@Test
	public void testChangePassword() {
		Member member = new Member("email.com", "pwd123", "Ű���");
		member.changedPassword("pwd123", "1234");
		System.out.println(member);
		assertEquals("1234", member.getPassword());
	}
	
	// ������й�ȣ(oldPassword)�� ��ġ���� ������� ����(IdPasswordNotMatchException) �߻�
	@Test(expected = IdPasswordNotMatchException.class) // ���ܰ� �߻����� �� �׽�Ʈ �ڵ尡 ������� ����
	public void testChangePassword2() {
		Member member = new Member("email.com", "pwd123", "Ű���");
		member.changedPassword("pwd", "1234");
		System.out.println(member);
		assertEquals("1234", member.getPassword());
	}

}
