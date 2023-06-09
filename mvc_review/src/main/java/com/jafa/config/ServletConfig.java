package com.jafa.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

// @Configuration : spring 어노테이션, 해당 클래스가 애플리케이션의 구성(Configuation)을 담당하는 클래스임을 표시 
	//  @Configuration 어노테이션이 지정된 클래스는 spring bean 설정을 포함, 이를 통해 application의 다양한 구성 요소를 정의하고 관리.

@Configuration 
@EnableWebMvc
@ComponentScan("com.jafa")
public class ServletConfig implements WebMvcConfigurer{

	@Override
	public void configureViewResolvers(ViewResolverRegistry registry) {
		registry.jsp("/WEB-INF/views/", ".jsp"); 
	}

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
	}


	
}
