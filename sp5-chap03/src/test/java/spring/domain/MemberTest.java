package spring.domain;

import static org.junit.Assert.*;

import org.junit.Test;

import spring.exception.IdPasswordNotMatchException;

public class MemberTest {

	@Test
	public void testChangePassword() {
		Member member = new Member("email.com", "pwd123", "키라라");
		member.changedPassword("pwd123", "1234");
		System.out.println(member);
		assertEquals("1234", member.getPassword());
	}
	
	// 기존비밀번호(oldPassword)가 일치하지 않을경우 예외(IdPasswordNotMatchException) 발생
	@Test(expected = IdPasswordNotMatchException.class) // 예외가 발생했을 때 테스트 코드가 통과함을 가정
	public void testChangePassword2() {
		Member member = new Member("email.com", "pwd123", "키라라");
		member.changedPassword("pwd", "1234");
		System.out.println(member);
		assertEquals("1234", member.getPassword());
	}

}
