package controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import spring.AuthInfo;
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
	public String form(LoginCommand loginCommand,
			@CookieValue(value = "REMEMBER", required = false) String remember) {
		if(remember!=null) {
			loginCommand.setEmail(remember);
			loginCommand.setRememberEmail(true);
		}
		return "login/loginForm";
	}
	
	@PostMapping
	public String submit(@Valid LoginCommand loginCommand, Errors errors, 
			HttpSession Session, HttpServletResponse response) {
		if(errors.hasErrors()) {
			return "login/loginForm";
		}
		try {
			AuthInfo authInfo = authService.authenticate(loginCommand.getEmail(), loginCommand.getPassword()); // TODO authInfo를 세션에 저장해야 함
			Session.setAttribute("authInfo", authInfo); // 세션에 authInfo라는 이름으로 authInfo객체 저장
			// authInfo 객체는 JSESSIONID에 연결되어 해당 세션에 속한 사용자 식별
			// Session(세션) : 웹 어플리케이션에서 클라이언트(웹 브라우저 등)와의 상태를 유지하기 위해 사용
			// - 인정 정보 유지 : 로그인한 사용자의 인정 정보(ID, 권한 등)를 세션에 저장, 세션을 통해 사용자를 식별, 인증 상태 유지
			// - 장바구니 정보 유지 : 사용자가 선택한 상품 정보를 세션에 저장, 장바구니 유지
			// - 사용자 상태 추적 : 사용자의 방문 횟수, 세션 기간 동안 사용자가 수행한 작업 등 추적
			// JSESSIONID : 클라이언트와 서버 간 통신 시 사용, 세션 식별에 사용되는 고유한 값
			
			// 쿠키 생성
			Cookie rememberCookie = new Cookie("REMEMBER", loginCommand.getEmail());
//			rememberCookie.setPath("/"); // 모든 경로 이하에 쿠키 적용 (기본값)
			if(loginCommand.isRememberEmail()) { // 이메일 기억
				rememberCookie.setMaxAge(60*60*24*7); // 7일간 쿠키 생성
			} else { // 이메일 기억 않기
				rememberCookie.setMaxAge(0); // 쿠키 만료
			}
			
			response.addCookie(rememberCookie);
			
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
