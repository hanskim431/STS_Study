package spring;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class RegisterRequest {

	@NotBlank(message = "필수입력값임")
	@Email(message = "올바른 Email 형식이 아님")
	private String email;
	
//	@Size(min=6,max=15,message = "비밀번호는 6~15자") // 검증기가 안통함
	@Pattern(regexp = "^.*(?=^.{8,15}$)(?=.*\\d)(?=.*[a-zA-Z])(?=.*[!@#$%^&+=]).*$", message = "8~15, 숫자 영문 특문 포함")
	private String password;
	
	@NotEmpty(message = "필수입력값임")
	private String confirmPassword;
	@NotEmpty(message = "필수입력값임")
	private String name;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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

	public boolean isPasswordEqualToConfirmPassword() {
		return password.equals(confirmPassword);
	}

	@Override
	public String toString() {
		return "RegisterRequest [email=" + email + ", password=" + password + ", confirmPassword=" + confirmPassword
				+ ", name=" + name + "]";
	}
}
