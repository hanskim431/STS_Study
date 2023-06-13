package controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import spring.DuplicateMemberException;
import spring.MemberRegisterService;
import spring.RegisterRequest;

@Controller
public class RegisterController {
	
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
			@RequestParam(value = "agree", defaultValue = "false") Boolean agreeVal) {
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
	public String handleStep3(@Valid RegisterRequest regReq, Errors errors) {
//		new RegisterRequestValidator().validate(regReq, errors); // @Valid가 하는 역할
		if (errors.hasErrors())
			return "register/step2";
		try {
			memberRegisterService.regist(regReq);
			return "register/step3";
		} catch (DuplicateMemberException ex) {
			errors.rejectValue("email", "duplicate");
			return "register/step2";
		}
	}
/*	// 4. 글로벌 범위 Validator와 컨트롤러 범위 Validator
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		// 컨트롤러에 적용할 Validator 설정 : 글로벌 Validator는 적용되지 않는다
		binder.setValidator(new RegisterRequestValidator()); // 글로벌 Validator 오버라이딩
//		binder.addValidators(new RegisterRequestValidator()); // 글로벌 Validator 적용 후 등록된 순서대로 Validator 적용 
	}
*/


	@InitBinder
	public void initBinder(WebDataBinder binder) {
		binder.addValidators(new PasswordMathchingValidator());
	}
	
}
