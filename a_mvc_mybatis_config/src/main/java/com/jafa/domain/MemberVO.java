package com.jafa.domain;

import java.time.LocalDateTime;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class MemberVO {

	private Long id;
	private String email;
	private String password;
	private String name;
	private LocalDateTime regDate;
}
