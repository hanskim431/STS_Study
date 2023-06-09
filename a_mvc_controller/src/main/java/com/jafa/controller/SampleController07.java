package com.jafa.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *  A controller for studying Cookie, setCookie, getCookie, deleteCookie 
 * 
 * @author HansKim
 *
 */

@Controller
@RequestMapping("/sample07")
public class SampleController07 {
	
	// Cookie : 쿠키, 
	@GetMapping("/setCookie")
	public String setCookie(HttpServletResponse response) {
		// 쿠키 생성
		Cookie cookie1 = new Cookie("spring", "spring5.0");
		Cookie cookie2 = new Cookie("jsp", "jsp2.5");
		
		// 유효시간 결정
		cookie1.setMaxAge(60*60);
		cookie2.setMaxAge(60*60);
		
		// response 객체 보관소에 쿠키 추가
		response.addCookie(cookie1);
		response.addCookie(cookie2);
		
		return "sample07/setCookie";
	}
	
	// 모든 쿠키 확인
	@GetMapping("/getCookie")
	public String getCookie(HttpServletRequest request) {
		Cookie[] cookies = request.getCookies();
		if(cookies != null) {
			for(Cookie c : cookies) {
				System.out.println("쿠키 이름 "+ c.getName());
				System.out.println("쿠키 값 "+ c.getValue());
			}
		}
		return "sample07/getCookie";
	}
	
	// 특정 이름 쿠키 확인
	@GetMapping("/getCookieByName")
	public String getCookieByName(HttpServletRequest request, String name) {
		Cookie[] cookies = request.getCookies();
		if(cookies != null) {
			for(Cookie c : cookies) {
				System.out.println("쿠키 이름 "+ c.getName());
				System.out.println("쿠키 값 "+ c.getValue());
				return "sample07/getCookieByName";
			}
		}
		return "sample07/other";
	}
	
	// 모든 쿠키 삭제
	@GetMapping("/delAllCookies")
	public String delAllCookie(HttpServletRequest request, HttpServletResponse response) {
		Cookie[] cookies = request.getCookies();
		if(cookies!=null) {
			for(Cookie c : cookies) {
				c.setMaxAge(0);
				response.addCookie(c);
			}
		}
		return "redirect:getCookie";
	}
	
	// 특정 이름의 쿠키 삭제
	@GetMapping("/delCookie")
	public String delCookie(HttpServletRequest request, HttpServletResponse response, 
			String name) {
		Cookie[] cookies = request.getCookies();
		if(cookies != null) {
			for(Cookie c : cookies) {
				if(c.getName().equals(name)) {
					c.setMaxAge(0);
					response.addCookie(c);
				}
			}
		}
		return "redirect:getCookie";
	}
}
