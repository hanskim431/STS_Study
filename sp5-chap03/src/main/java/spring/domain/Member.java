package spring.domain;


import java.util.Date;

import spring.exception.IdPasswordNotMatchException;

public class Member {
	private Long id;
	private String email;
	private String password;
	private String name;
	private Date registerDate;
	
	public void changedPassword(String oldPassword, String newPassword) { // 비밀번호 변경 메소드
		if(!password.equals(oldPassword)) { // 비밀번호가 일치하지 않으면
			// 예외를 던짐
			throw new IdPasswordNotMatchException();
		}
		// 일치하면 비밀번호 변경
		this.password = newPassword;
	}
	
	public Member() {} // 기본 생성자
	
	public Member(String email, String password, String name) { // 생성자
		super();
		this.email = email;
		this.password = password;
		this.name = name;
	}

	// getter setter
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getRegisterDate() {
		return registerDate;
	}

	public void setRegisterDate(Date registerDateTime) {
		this.registerDate= registerDateTime;
	}

	// toString
	@Override
	public String toString() {
		return "Member [id="+id+",email="+email+",password="+password+",name="+name+",registerDate="+registerDate+"]";
	}


	
	
}
