package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import spring.RegisterRequest;

@Controller
public class RegisterController {

	@GetMapping("/register/step1")
	public String handleStep1() {
		return "register/step1";
	}
	
	@PostMapping("/register/step2")
	public String handleStep2(RegisterRequest registerRequest,
			@RequestParam(value = "agree", defaultValue = "false") Boolean agree) {
		if(!agree) {
			return "register/step1";
		}
		return "register/step2";
	}
}
