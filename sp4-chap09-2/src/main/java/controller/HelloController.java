package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloController {

	
	@RequestMapping("/")
	public String main () {
		return "main";
	}
	
	@RequestMapping("/hello")
	public String hello () {
		return "hello";
	}
}
