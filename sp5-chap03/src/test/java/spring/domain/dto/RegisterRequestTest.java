package spring.domain.dto;

import static org.junit.Assert.*;

import org.junit.Test;

public class RegisterRequestTest {

	@Test
	public void test() {
		RegisterRequest registerRequest = new RegisterRequest();
		registerRequest.setPassword("1234");
		registerRequest.setConfirmPassword("11234");
		assertTrue("일치하지 않음",registerRequest.isPasswordEqualToConfirmPassword());
	}

}
