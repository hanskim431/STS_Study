package com.jafa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jafa.dao.SampleDao;

/**
 *  A controller for studying @PathVariable, @PathVariable(required = false), @PathVariable(value = "경로변수"), @PathVariable 다수의 경로변수
 * 
 * @author HansKim
 *
 */

@Controller
@RequestMapping("/sample03")
public class SampleController03 {
	
	@Autowired
	private SampleDao sampleDao; // SampleDao를 자동 주입 : sample 객체를 사용해 DB와 상호작용 가능케 함
	
	// @PathVariable
	// 요청 : /sample03/member/kim
	// @PathVariable : 경로 변수의 값을 메소드의 파라미터로 받아옴
	// - 파라미터 이름과 동일한 이름을 갖는 경로 변수 사용
	// - 요청 경로가 /sample03/member/lee일 경우
	// - 파라미터 memberId에 lee값이 전달된다.
	// - 파라미터로 선언된 memberId는 뷰 페이지에서 이름을 memberId로 사용할 수 있음
	@GetMapping("/member/{memberId}")
	public String myPage1(@PathVariable String memberId) { // @PathVariable은 {memberId}의 경로값을 memberId 매개변수에 삽입
		System.out.println(memberId);
		return "sample03/detail01";
	}
	
	// @PathVariable(required = false)
	// required = false 요구사항 필수 비활성화 ( 기본값 : true )
	// true 로 요구사항 필수 활성화 후 비워둘 시 : Missing URI template variable 'memberId' for method parameter of type String
	@GetMapping({"/member2/{memberId}","/member2"}) // 값을 전달하지 않을 경우 값이 없는 경우의 경로를 지정함
	public String myPage2(@PathVariable(required = false) String memberId) { 
		System.out.println(memberId);
		return "sample03/detail01";
	}

	// @PathVariable(value = "경로변수")
	// - 파라미터 이름과 경로변수가 다를 경우
	// - value 만 단독으로 사용할 경우 생략 가능
	// - 뷰에서 value(경로변수)와 동일한 이름을 사용함(memberId)
	@GetMapping("/member3/{memberId}")
	public String myPage3(@PathVariable(value = "memberId") String userId) {
		System.out.println(userId);
		return "sample03/detail03";
	}
	
	// @PathVariable 다수의 경로변수
	// - 하나 이상의 경로 변수를 사용할 수 있다.
	// - 래퍼타입 또는 기본타입에 @PathVariable를 적용하면 문자열을 해당 타입으로 변환한다.
	@GetMapping("/member4/{memberId}/{mno}")
	public String myPage4(@PathVariable String memberId, @PathVariable Long mno) {
		System.out.println(memberId);
		System.out.println(mno);
		return "sample03/detail04";
	}
}
