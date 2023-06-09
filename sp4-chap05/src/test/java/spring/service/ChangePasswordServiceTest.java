package spring.service;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import spring.dao.MemberDao;
import spring.domain.Member;
import spring.domain.dto.RegisterRequest;
import spring.exception.IdPasswordNotMatchException;
import spring.exception.MemberNotFoundException;

public class ChangePasswordServiceTest {
	// �̸����� �߸� ���� �� ; ȸ�� ������ ã�� �� ���� ��� : MemberNotFoundException
	// �̸����� ���� �� ; ȸ�� ������ �ִ� ��� : 
		// ��й�ȣ�� ��ġ���� ���� �� : IdPasswordNotMatchException
		// ��й�ȣ�� ��ġ�� ��

	private ChangePasswordService service;
	private MemberDao memberdao;
	
	@Before
	public void setUp() {
		memberdao = new MemberDao();
		service = new ChangePasswordService(memberdao);
	}
	
	// �̸����� �߸� ���� �� ; ȸ�� ������ ã�� �� ���� ��� : MemberNotFoundException
	@Test (expected = MemberNotFoundException.class)
	public void testChangePassword1() {
		service.changePassword("go1@test.com", "1111", "9999");
	}

	// ��й�ȣ�� ��ġ���� ���� �� : IdPasswordNotMatchException
	@Test (expected = IdPasswordNotMatchException.class)
	public void testChangePassword2() {
		service.changePassword("go@test.com", "11111", "9999");
	}
	
	// ��й�ȣ�� ��ġ�� ��
	@Test
	public void testChangePassword3() {
		service.changePassword("go@test.com", "1111", "9999");
		
		Member findMember = memberdao.selectByEmail("go@test.com");
		System.out.println(findMember); // password�� �ٲ������ �ܼ� ��� Ȯ��
		
		assertEquals("9999", findMember.getPassword()); // findMember�� password�� 9999���� ����
	}
	
}
