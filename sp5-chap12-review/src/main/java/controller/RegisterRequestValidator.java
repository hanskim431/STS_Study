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

	private Pattern pattern;

	@Autowired
	private MemberDao memberDao;
	
	public void setMemberDao(MemberDao memberDao) {
		this.memberDao = memberDao;
	}

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
		
		// 이메일
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
		
		// 이름
		if(regReq.getName()==null || regReq.getName().trim().isEmpty()) { // 이메일 항목을 비워뒀을 때 오류를 발생
			errors.rejectValue("name", "required"); // email 필드에 에러가 있을 떄 "required"라는 에러가 뜸
		} else {
			pattern = Pattern.compile(nameRegExp);
			Matcher matcher = pattern.matcher(regReq.getName());
			if (!matcher.matches()) {
				errors.rejectValue("name", "bad");
			} 
			
		}
		
		// 비밀번호
		if(regReq.getPassword()==null || regReq.getPassword().trim().isEmpty()) { // 이메일 항목을 비워뒀을 때 오류를 발생
			errors.rejectValue("password", "required"); // email 필드에 에러가 있을 떄 "required"라는 에러가 뜸
		} else {
			pattern = Pattern.compile(pwdRegExp);
			Matcher matcher = pattern.matcher(regReq.getPassword());
			if (!matcher.matches()) {
				errors.rejectValue("password", "bad");
			} 
		}
		
		// 비밀번호 확인
		if(regReq.getConfirmPassword()==null || regReq.getConfirmPassword().trim().isEmpty()) { // 이메일 항목을 비워뒀을 때 오류를 발생
			errors.rejectValue("confirmPassword", "required"); // email 필드에 에러가 있을 떄 "required"라는 에러가 뜸
		} else {
			if (!regReq.isPasswordEqualToConfirmPassword()) {
				errors.rejectValue("confirmPassword", "nomatch");
			}
		}
	}
}