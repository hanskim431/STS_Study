package spring.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MemberDTO {// DTO : Data Transfer Object, 데이터의 전송을 목적, DB에서 조회한 결과나 서비스 간에 데이터를 전달하기 위해 사용
	private String email;
	private String password;
	private String confirmPassword;
	private String name;
	
	public boolean isPasswordEqualToPassword() {
		return password.equals(confirmPassword);
	}
}
