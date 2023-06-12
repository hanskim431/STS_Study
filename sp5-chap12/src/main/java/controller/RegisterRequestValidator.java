package controller;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import spring.Member;
import spring.MemberDao;
import spring.RegisterRequest;

public class RegisterRequestValidator implements Validator{

	private Pattern pattern;
	
	private MemberDao memberDao;

	public void setMemberDao(MemberDao memberDao) {
		this.memberDao = memberDao;
	}

	private static final String emailRegExp = 
			"^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@" +
			"[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
	
	private static final String nameRegExp = "^[가-힣]*$";

	private static final String pwdRegExp = 
			"^.*(?=^.{8,15}$)(?=.*\\d)(?=.*[a-zA-Z])(?=.*[!@#$%^&+=]).*$";
	
	@Override
	public boolean supports(Class<?> clazz) {
		return RegisterRequest.class.isAssignableFrom(clazz);
	}

	// .trim() : 양쪽의 공백을 없에줌
	@Override
	public void validate(Object target, Errors errors) {
		RegisterRequest regReq = (RegisterRequest) target;
		
		if(regReq.getEmail()==null || regReq.getEmail().trim().isEmpty()) { // 이메일 항목을 비워뒀을 때 오류를 발생
			errors.rejectValue("email", "required"); // email 필드에 에러가 있을 떄 "required"라는 에러가 뜸
		} else {
			pattern = Pattern.compile(emailRegExp);
			Matcher matcher = pattern.matcher(regReq.getEmail());
			if (!matcher.matches()) {
				errors.rejectValue("email", "bad");
			}
			Member member = memberDao.selectByEmail(regReq.getEmail());
			if(member!=null) {
				errors.rejectValue("email", "duplicate");
			}
		}
		
		if(regReq.getName()==null || regReq.getName().trim().isEmpty()) {
			errors.rejectValue("name", "required");
		} else {
			pattern = Pattern.compile(nameRegExp);
			Matcher matcher = pattern.matcher(regReq.getName());
			if(!matcher.matches()) {
				errors.rejectValue("name", "hangul");
			}
		}
		
		if(regReq.getPassword()==null || regReq.getPassword().trim().isEmpty()) {
			ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "required");
			ValidationUtils.rejectIfEmptyOrWhitespace(errors, "confirmPassword", "required");
		} else {
			pattern = Pattern.compile(pwdRegExp);
			Matcher matcher = pattern.matcher(regReq.getPassword());
			
			if(!matcher.matches()) {
				errors.rejectValue("password", "bad");
			} else if(!regReq.getPassword().isEmpty() && !regReq.isPasswordEqualToConfirmPassword()) {
				errors.rejectValue("confirmPassword", "nomatch");
			}
		}
	}
}
