package com.jafa.config;

import javax.servlet.Filter;

import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

// WebConfig : 스프링 mvc 웹 앱에서 설정을 담당. 주로 Dispatcher Servlet 설정과 관련된 내용을 정리
public class WebConfig extends AbstractAnnotationConfigDispatcherServletInitializer{ 
	// AACS 상속, 웹 앱 초기화 설정
	
	
	// 스프링 빈의 설정정보
	@Override
	protected Class<?>[] getRootConfigClasses() {
		return new Class[] {RootConfig.class}; // RootConfig 클래스를 반환하도록 지정
	}

	// 디스패쳐 서블릿 설정 정보 
	@Override
	protected Class<?>[] getServletConfigClasses() {
		return new Class[] {ServletConfig.class};
	}

	// 서블릿 필터 설정
	@Override
	protected String[] getServletMappings() {
		return new String[] {"/"} ; // '/' 이하의 모든 요청을 받음
	}

	@Override
	protected Filter[] getServletFilters() {
		CharacterEncodingFilter filter = new CharacterEncodingFilter();
		filter.setEncoding("UTF-8");
		filter.setForceEncoding(true);
		return new Filter[] {filter};
	}
}
