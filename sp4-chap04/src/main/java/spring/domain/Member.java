package spring.domain;


import java.util.Date;

import spring.exception.IdPasswordNotMatchException;

public class Member {
	private Long id;
	private String email;
	private String password;
	private String name;
	private Date registerDate;
	
	public void changedPassword(String oldPassword, String newPassword) { // ��й�ȣ ���� �޼ҵ�
		if(!password.equals(oldPassword)) { // ��й�ȣ�� ��ġ���� ������
			// ���ܸ� ����
			throw new IdPasswordNotMatchException();
		}
		// ��ġ�ϸ� ��й�ȣ ����
		this.password = newPassword;
	}
	
	public Member() {} // �⺻ ������
	
	public Member(String email, String password, String name) { // ������
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
