package spring.service;

import static org.junit.Assert.fail;

import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import spring.AppTest;

public class ChangePasswordServiceTest extends AppTest{
	
	@Autowired
	ChangePasswordService changePasswordService;

	@Test
	public void test1() {
		changePasswordService.changePassword("kim@test.com", "1234", "1111");
	}
	
	@Test
	@Ignore
	public void test2() {
		changePasswordService.changePassword("park@test.com", "1234", "1111");
	}
	
	@Test
	@Ignore
	public void test3() {
		changePasswordService.changePassword("lee@test.com", "12312", "1111");
	}

}
