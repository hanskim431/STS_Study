package domain;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class MemberVO {
	
	// 멤버 필드
	private Long id;
	private String name;
	private String email;
	private String password;
	private Date regDate;
	
	// 멤버 생성자 
	public MemberVO(Long id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	
	
}
