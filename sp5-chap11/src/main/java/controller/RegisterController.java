package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import spring.DuplicateMemberException;
import spring.MemberRegisterService;
import spring.RegisterRequest;

@Controller
public class RegisterController {
	
	@Autowired
	private MemberRegisterService memberRegisterService;
	
	public void setMemberRegisterService(MemberRegisterService memberRegisterService) {
		this.memberRegisterService = memberRegisterService;
	}

	@GetMapping("/register/step1")
	public String handleStep1() {
		return "/register/step1";
	}
	
	@PostMapping("/register/step2")
	public String handleStep2(
			RegisterRequest registerRequest,
			@RequestParam(value = "agree", defaultValue = "false") Boolean agreeVal) { // value, defaultValue 생략해도 되나 적어주는게 명확함
		System.out.println(agreeVal);
		if(!agreeVal) {
			return "/register/step1";
		}
		return "/register/step2";
	}
	
	@GetMapping("/register/step2")
	public String handleStep2Get() {
		return "redirect:/register/step1";
	}
	
	@PostMapping("/register/step3")
	public String handleStep3(RegisterRequest regReq) {
		try {
			memberRegisterService.regist(regReq);
			return "/register/step3";
		} catch (DuplicateMemberException e) {
			return "/register/step2";
		}
	}
}
