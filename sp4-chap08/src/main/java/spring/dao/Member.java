package spring.dao;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.ToString;
import spring.exception.WrongIdPasswordException;

@AllArgsConstructor
@RequiredArgsConstructor
@ToString
@Getter
public class Member {
	private Long id;
	private final String email;
	@NonNull
	private String password;
	private final String name;
	private Date date;
	
	public void changePassword(String curPwd, String newPwd) {
		if(!password.equals(curPwd)) {
			throw new WrongIdPasswordException(); 
		}
		this.password = newPwd;
	}
	
}

//final 필드를 사용하면 @NoArgsConstructor(기본생성자) 사용 불가능
//단 @NonNull을 사용하면 가능