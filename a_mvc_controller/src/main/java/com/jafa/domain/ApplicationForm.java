package com.jafa.domain;

import java.util.List;

import lombok.Setter;
import lombok.ToString;
import lombok.Getter;

@Getter
@Setter
@ToString
public class ApplicationForm {
	private String name; // 지원자 성명
	private String email; // 지원자 이메일
	private List<University> universityList;
}
