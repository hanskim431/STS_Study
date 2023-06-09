package com.jafa.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.jafa.domain.SampleVO;

/**
 *  A controller for studying @RequestMapping, @GetMapping, @PostMapping, @ModelAttribute
 * 
 * @author HansKim
 *
 */

@Controller
@RequestMapping("/sample02") // 클래스 단위에 @RequtestMapping 적용
//	@RequestMapping 어노테이션 : 핸들러 메서드를 지정한 경로와 HTTP 메서드에 매핑
// - value(), path() : 요청 경로 지정, Ant 스타일 패턴 허용
// - method() : 요청에 대한 HTTP 메서드 지정
public class SampleController02 {

	// @RequestMapping
	// @RequestMapping("list1") 와 동일
	// - value 속성을 단독으로 사용할 경우 속성명을 생략할 수 있음 (모던 어노테이션의 공통 사항)
	// - GET 방식 요청 : method 속성 생략 가능
	// 요청 : /sample02/list1
	@RequestMapping(value = "/list1", method = RequestMethod.GET)
	public String list1() {
		return "sample02/sampleList01";
	}

	// @RequestMapping 매핑 배열 지정
	// 요청 : /sample02/list2 또는 /sample02/list
	@RequestMapping({"/list2", "/list"}) // 배열을 사용하면 여러 요청 경로를 지정할 수 있음
	public String list2() {
		return "sample02/sampleList02";
	}

	// @GetMapping
	// @RequestMapping(value = "/sampleForm", method = RequestMethod.GET) 와 동일
	// 요청 : /sample02/sampleForm
	@GetMapping("/sampleForm") 
	public String sampleForm() {
		return "sample02/sampleForm";
	}

	// @PostMapping, 커맨드 객체(Command Object), @ModelAttribute
	// @RequestMapping(value = "/sampleProcced", method = RequestMethod.POST) 와 동일
	// 요청 : 없음, POST 메소드
	// 커맨드 객체 : 웹 애플리케이션에서 클라이언트로부터 전송된 데이터를 바인딩하는 데 사용되는 객체
	// - 컨트롤러 메소드에 사용된 참조타입 파라미터를 커맨드 객체라고 함(단, String, Wrapper 제외)
	// - 커맨드 객체는 Model에 데이터를 등록하지 않고 뷰에서 사용할 수 있다.
	// - 이 때 뷰 페이지에서 사용할 이름은 SampleVO의 소문자 sampleVO이다 (타입에서 첫글자 소문자화)
	// - 단, 뷰에서 사용할 이름을 변경하려면 @ModelAttribute어노테이션 사용
	// ** 커맨드 객체를 사용하려면 기본 생성자가 반드시 있어야함
	@PostMapping("/sampleProcced")
	public String sampleProceed(@ModelAttribute("svo") SampleVO vo) {
		System.out.println(vo);
		return "sample02/sampleResult";
	}
}
