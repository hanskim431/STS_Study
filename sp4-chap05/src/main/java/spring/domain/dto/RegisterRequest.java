package spring.domain.dto;

public class RegisterRequest {

	String eamil;
	String password;
	String confirmPassword;
	String name;
	
	// 비밀번호 일치 확인 여부
	public boolean isPasswordEqualToConfirmPassword() {
		return password.equals(confirmPassword); 
	}
	
	public String getEamil() {
		return eamil;
	}
	public void setEamil(String eamil) {
		this.eamil = eamil;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getConfirmPassword() {
		return confirmPassword;
	}
	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
}