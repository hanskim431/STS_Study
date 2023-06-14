package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/sample")
public class SampleController {
	
	@GetMapping("/test1")
	public String test01() {
		System.out.println("SampleController.test01() 호출");
		return "test1";
	}
	
	@GetMapping("/test2")
	public String test02() {
		System.out.println("SampleController.test02() 호출");
		return "test2";
	}
	
	@GetMapping("/test3")
	public String test03() {
		System.out.println("SampleController.test03() 호출");
		return "test3";
	}
}
