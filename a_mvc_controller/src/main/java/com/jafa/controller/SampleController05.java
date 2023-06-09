package com.jafa.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jafa.domain.ReportCard;
import com.jafa.domain.StudentVO;

/**
 *  A controller for studying 커맨드 객체의 중첩 객체 프로퍼티 처리
 * 
 * @author HansKim
 *
 */

// 커맨드 객체(StudentVO)의 중첩객체(ReportCard) 프로퍼티 처리
// 요청 : /sample05/report
@Controller
@RequestMapping("/sample05")
public class SampleController05 {
	
	@GetMapping("/report")
	public String reportForm() {
		return "/sample05/reportForm";
	}

	@PostMapping("/report")
	public String report(StudentVO vo) {
		System.out.println(vo);
		return "/sample05/reportResult";
	}
}

/*
== 커맨드 객체의 중접 객체 프로퍼티 ==
public class StudentVO { // 커맨드 객체
	private String name; // JSP 에서 name="name" 으로 주입
	private String email; // JSP 에서 name="email" 으로 주입
	private ReportCard reportCard;
}

public class ReportCard { // 중첩 객체
	private int eng; // JSP 에서 name="reportCard.eng" 으로 주입
	private int math; // JSP 에서 name="reportCard.math" 으로 주입
	private int science; // JSP 에서 name="reportCard.science" 으로 주입
}

studentVO.name: 학생 이름 프로퍼티
studentVO.email: 학생 이메일 프로퍼티
studentVO.reportCard.eng: 학생 성적의 영어 점수 프로퍼티
studentVO.reportCard.math: 학생 성적의 수학 점수 프로퍼티
studentVO.reportCard.science: 학생 성적의 과학 점수 프로퍼티

 */
