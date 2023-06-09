package spring.dao;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@RequiredArgsConstructor
@NoArgsConstructor
@ToString
@Getter
@Setter
public class Member {
	private Long id;
	@NonNull
	private String email;
	@NonNull
	private String password;
	@NonNull
	private String name;
	private Date date;
}
