package controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import spring.AuthService;
import spring.WrongIdPasswordException;

@Controller
@RequestMapping("/login")
public class LoginController {
	
	private AuthService authService;

	public void setAuthService(AuthService authService) {
		this.authService = authService;
	}
	
	@GetMapping
	public String form(LoginCommand loginCommand) {
		return "login/loginForm";
	}
	
	@PostMapping
	public String submit(@Valid LoginCommand loginCommand, Errors errors) {
		if(errors.hasErrors()) {
			return "login/loginForm";
		}
		try {
			authService.authenticate(loginCommand.getEmail(), loginCommand.getPassword());
		} catch (WrongIdPasswordException e) {
			errors.reject("idPasswordNotMatching");
			return "login/loginForm";
		}
		
		return "login/loginSuccess";
	}
	
	@InitBinder
	public void nitBinder(WebDataBinder binder)	{
		binder.addValidators(new LoginCommandValidator());
	}
}
