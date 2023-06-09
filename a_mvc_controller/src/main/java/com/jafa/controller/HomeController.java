package com.jafa.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller // 스프링에게 이 크래스가 컨트롤러임을 알리는 어노테이션
public class HomeController {

	@GetMapping("/") // HTTP GET 요청을 처리하는 메서드에 사용되는 어노테이션 
	public String home() {
		return "index"; // /WEB-INF/views/index.jsp
	}
}
