package spring.service;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import spring.AppTest;

public class ChangePasswordServiceTest2 extends AppTest{

	@Autowired
	ChangePasswordService changePasswordService;
	
	@Test
	public void test() {
		changePasswordService.changePassword("go@test.com", "9999", "3333");
	}

}
