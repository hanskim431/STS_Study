package controller;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import spring.Member;
import spring.MemberDao;
import spring.RegisterRequest;

// org.springframework.validation.Validator
public class RegisterRequestValidator implements Validator { 

	@Autowired
	private MemberDao memberDao;
	
	public void setMemberDao(MemberDao memberDao) {
		this.memberDao = memberDao;
	}

	private Pattern pattern;

	private static final String emailRegExp = 
			"^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@" +
			"[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
	
	private static final String nameRegExp = 
			"^[가-힣]*$";
	
	private static final String pwdRegExp = 
			"^.*(?=^.{8,15}$)(?=.*\\d)(?=.*[a-zA-Z])(?=.*[!@#$%^&+=]).*$";
	
	@Override
	public boolean supports(Class<?> clazz) {
		return RegisterRequest.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		RegisterRequest regReq = (RegisterRequest) target;
		// null 또는 공백문자이거나 빈문자 일 때 
		if (regReq.getEmail() == null || regReq.getEmail().trim().isEmpty()) {
			errors.rejectValue("email", "required");
//			errors.rejectValue("email", "test");
		} else {
			// java.util.regex.Matcher
			pattern = Pattern.compile(emailRegExp);
			Matcher matcher = pattern.matcher(regReq.getEmail());
			if (!matcher.matches()) {
				errors.rejectValue("email", "bad");
			} else {
				Member member = memberDao.selectByEmail(regReq.getEmail());
				if(member!=null) {
					errors.rejectValue("email", "duplicate");
				}
			}
		}
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "required");
		ValidationUtils.rejectIfEmpty(errors, "password", "required");
		ValidationUtils.rejectIfEmpty(errors, "confirmPassword", "required");
		if (!regReq.getPassword().isEmpty() && 
				!regReq.isPasswordEqualToConfirmPassword()) {
			errors.rejectValue("confirmPassword", "nomatch");
		}
	}
}