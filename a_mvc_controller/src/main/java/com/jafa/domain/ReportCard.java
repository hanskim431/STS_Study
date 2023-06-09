package com.jafa.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ReportCard { // 중첩 객체
	private int eng;
	private int math;
	private int science;
}
