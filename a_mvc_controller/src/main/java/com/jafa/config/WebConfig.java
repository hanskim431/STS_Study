package com.jafa.config;


import javax.servlet.Filter;

import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

// WebConfig : 스프링 mvc 웹 앱에서 설정을 담당함. 주로 Dispatcher Servlet설정과 관련된 내용을 정리
public class WebConfig extends AbstractAnnotationConfigDispatcherServletInitializer{

	// 스프링 빈의 설정정보
	@Override
	protected Class<?>[] getRootConfigClasses() {
		System.out.println("getRootConfigClasses()"); // ServletContext 보관소 전달
		return new Class[] {RootConfig.class};
	}

	// 디스패처 서블릿 설정 정보 반환
	@Override
	protected Class<?>[] getServletConfigClasses() {
		System.out.println("getServletConfigClasses()"); // ServletConfig 보관소 전달
		return new Class[] {ServletConfig.class};
	}

	// 디스패처 서블릿 매핑 정보 반환
	@Override
	protected String[] getServletMappings() {
		return new String[] {"/"}; // '/' 이하의 모든 요청을 받음
	}
	
	@Override
	protected Filter[] getServletFilters() {
		CharacterEncodingFilter filter = new CharacterEncodingFilter();
		filter.setEncoding("utf-8");
		filter.setForceEncoding(true);
		return new Filter[] {filter};
		
	}
	
}
