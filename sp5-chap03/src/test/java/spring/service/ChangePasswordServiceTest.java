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
	// 이메일이 잘못 됐을 때 ; 회원 정보를 찾을 수 없는 경우 : MemberNotFoundException
	// 이메일이 맞을 때 ; 회원 정보가 있는 경우 : 
		// 비밀번호가 일치하지 않을 떄 : IdPasswordNotMatchException
		// 비밀번호가 일치할 때

	private ChangePasswordService service;
	private MemberDao memberdao;
	
	@Before
	public void setUp() {
		memberdao = new MemberDao();
		service = new ChangePasswordService(memberdao);
	}
	
	// 이메일이 잘못 됐을 때 ; 회원 정보를 찾을 수 없는 경우 : MemberNotFoundException
	@Test (expected = MemberNotFoundException.class)
	public void testChangePassword1() {
		service.changePassword("go1@test.com", "1111", "9999");
	}

	// 비밀번호가 일치하지 않을 떄 : IdPasswordNotMatchException
	@Test (expected = IdPasswordNotMatchException.class)
	public void testChangePassword2() {
		service.changePassword("go@test.com", "11111", "9999");
	}
	
	// 비밀번호가 일치할 때
	@Test
	public void testChangePassword3() {
		service.changePassword("go@test.com", "1111", "9999");
		
		Member findMember = memberdao.selectByEmail("go@test.com");
		System.out.println(findMember); // password가 바뀌었는지 콘솔 출력 확인
		
		assertEquals("9999", findMember.getPassword()); // findMember의 password가 9999인지 검증
	}
	
}
