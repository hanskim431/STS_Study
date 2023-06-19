//package controller;
//
//import java.time.LocalDateTime;
//
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.ResponseBody;
//import org.springframework.web.bind.annotation.RestController;
//
//import spring.Member;
//
////@RestController
//@Controller
//@ResponseBody
//public class SampleRestMemberController {
//
//	@GetMapping("/rest/test")
//	@ResponseBody
//	public String test() {
//		return "hello";
//	}
//	
//	@GetMapping("rest/sample")
//	@ResponseBody
//	public SampleBean sampleBean() {
//		return new SampleBean();
//	}
//	
//	@GetMapping("rest/member")
//	@ResponseBody
//	public Member member() {
//		Member vo = new Member("lee@test.com", "1111", "lee", LocalDateTime.of(2023, 6, 10, 0, 0));
//		return vo;
//	}
//	
//	
//}
//
//class SampleBean {
//	String test01 = "test01";
//	String test02 = "test02";
//	
//	public String getTest01() {
//		return test01;
//	}
//	public void setTest01(String test01) {
//		this.test01 = test01;
//	}
//	public String getTest02() {
//		return test02;
//	}
//	public void setTest02(String test02) {
//		this.test02 = test02;
//	}
//	
//	
//}
