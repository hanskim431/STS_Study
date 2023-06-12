package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import spring.MemberRegisterService;
import spring.RegisterRequest;

@Controller
public class RegisterController {
	
	@Autowired
	private RegisterRequestValidator registerRequestValidator;

	private MemberRegisterService memberRegisterService;
	
	public void setMemberRegisterService(MemberRegisterService memberRegisterService) {
		this.memberRegisterService = memberRegisterService;
	}

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
	
	@GetMapping("/register/step2")
	public String handleStep2Get() {
		return "redirect:/register/step1";
	}
	
	@PostMapping("/register/step3")
	public String handleStep3(RegisterRequest regReg, Errors errors) { // error 객체는 반드시 커맨드 객체 옆에 두어야함
		registerRequestValidator.validate(regReg, errors);
		if(errors.hasErrors()) {
			System.out.println("에러가 있습니다.");
			return "/register/step2"; 
		}
		memberRegisterService.regist(regReg);
		return "/register/step3";
	}
}
