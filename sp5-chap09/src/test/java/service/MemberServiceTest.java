package service;

import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import config.AppTest;
import domain.MemberVO;

public class MemberServiceTest extends AppTest{ // AppTest로 @RunWith @ContextConfiguration 상속 받음

	@Autowired
	MemberService memberService;
	
	@Test
	@Ignore
	public void testList() {
		System.out.println(memberService.members());
	}
	
	@Test
	@Ignore
	public void testGet() {
		System.out.println(memberService.memberInfo("go@test.com"));
		System.out.println(memberService.memberInfo("kim@test.com"));
	}
	
	@Test
	@Ignore
	public void testRegister() {
		MemberVO vo = new MemberVO();
		vo.setEmail("gone@test.com");
		vo.setName("고니");
		vo.setPassword("1234");
		memberService.register(vo);
		System.out.println(vo);
	}
	
//	// 키 홀더 미사용
//	@Test
////	@Ignore
//	public void testRegister2() {
//		MemberVO vo = new MemberVO();
//		vo.setEmail("gone@test.com");
//		vo.setName("고니");
//		vo.setPassword("1234");
//		memberService.register2(vo);
//		System.out.println(vo);
//	}
	
}
