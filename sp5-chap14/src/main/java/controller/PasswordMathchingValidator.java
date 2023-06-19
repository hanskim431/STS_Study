package controller;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import spring.RegisterRequest;

public class PasswordMathchingValidator implements Validator{

	@Override
	public boolean supports(Class<?> clazz) {
		return RegisterRequest.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		RegisterRequest regReq = (RegisterRequest) target;
		if (!regReq.getPassword().isEmpty() && !regReq.isPasswordEqualToConfirmPassword()) {
			errors.rejectValue("confirmPassword", "nomatch");
		}
	}
}
