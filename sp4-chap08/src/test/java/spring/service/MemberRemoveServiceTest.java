package spring.service;

import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import spring.AppTest;
import spring.exception.MemberNotFoundException;

public class MemberRemoveServiceTest extends AppTest{

	@Autowired
	MemberRemoveService memberRemoveService;
	
	@Test
//	@Ignore
	public void testRemove1() {
		memberRemoveService.remove("go@test.com");
	}
	
	@Test(expected = MemberNotFoundException.class)
	@Ignore
	public void testRemove2() {
		memberRemoveService.remove("kim@test.com");
	}

}
