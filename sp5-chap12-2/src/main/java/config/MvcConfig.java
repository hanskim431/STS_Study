package config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.validation.Validator;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

import controller.RegisterRequestValidator;

@EnableWebMvc
@Configuration
public class MvcConfig implements WebMvcConfigurer{
	
	@Override
	public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
		configurer.enable();
	}
	
	@Override
	public void configureViewResolvers(ViewResolverRegistry registry) {
		registry.jsp("/WEB-INF/view/",".jsp");
	}

	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("/main").setViewName("main");
	}
	
//	@Bean
//	public ResourceBundleMessageSource messageSource() { // 빈id를 반드시 messageSource로 지정해야함
//		ResourceBundleMessageSource ms = new ResourceBundleMessageSource(); 
		// message property 파일의 위치, 이름 지정
//		ms.setBasenames("message.label","errors.error"); // classpath:message/label.properties, errors/error.properties 
		// 기본 인코딩 지정
//		ms.setDefaultEncoding("UTF-8");
//		return ms;
//	}
	
	@Bean
	public ReloadableResourceBundleMessageSource messageSource() {
		ReloadableResourceBundleMessageSource  ms = new ReloadableResourceBundleMessageSource();
		ms.setBasenames("classpath:/message/label", "classpath:/errors/error", 
				"file:C:/Users/s/Documents/workspace-sts-3.9.18.RELEASE/sp5-chap12-2/src/message/test");
		ms.setDefaultEncoding("UTF-8");
		return ms;
	}
	
	/*
	 * 다국어 처리 
	 * 참고 :
	 * https://url.kr/ef8qbl
	 * 동 https://velog.io/@bey1548/Spring%EC%97%90%EC%84%9C-%EB%8B%A4%EA%B5%AD%EC%96%B4-%EC%A0%81%EC%9A%A9%ED%95%98%EA%B8%B0
	 */
	 
	// localeResolver : 다국어처리 방법을 선택
	// - AcceptHeaderLocaleResolver (default) : 브라우저에 설정된 언어값을 읽어 처리
	// - SessionLocaleResolver : request가 갖고있는 session의 locale 정보를 획득, 만약 값이 없다면 defaultLocale로 지정
	// - CookieLocaleResolver : 언어를 변경하고 쿠키에 값을 저장
	@Bean
	public SessionLocaleResolver localeResolver() {
		return new SessionLocaleResolver();
	}
	
	// LocaleChangeInterceptor : 언어 변경을 위한 인터셉터 생성, 사용자가 url을 통해서 언어를 변경할 경우 사용
	@Bean
	public LocaleChangeInterceptor localeChangeInterceptor() {
		LocaleChangeInterceptor interceptor = new LocaleChangeInterceptor();
		interceptor.setParamName("lang");
		return interceptor;
	}
	
	// 인터셉터 등록
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(localeChangeInterceptor());
	}
	
//	// 유효성 검사 
//	@Override
//	public Validator getValidator() {
//		return new RegisterRequestValidator();
//	}
	
}
