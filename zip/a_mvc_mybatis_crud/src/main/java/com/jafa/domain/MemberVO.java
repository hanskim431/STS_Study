package com.jafa.domain;

import java.time.LocalDateTime;

import org.apache.ibatis.type.Alias;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Alias("member")
public class MemberVO {

	private Long id;
	private String email;
	private String password;
	private String name;
	private LocalDateTime regDate;
}
