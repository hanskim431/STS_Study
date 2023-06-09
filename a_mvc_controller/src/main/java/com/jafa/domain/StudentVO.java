package com.jafa.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class StudentVO { // 커맨드 객체
	private String name;
	private String email;
	private ReportCard reportCard;
}
