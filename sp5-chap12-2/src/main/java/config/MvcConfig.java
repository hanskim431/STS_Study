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
//		ms.setBasenames("message.label","errors.error"); // classpath:message/label.properties, errors/error.properties 
//		ms.setDefaultEncoding("UTF-8");
//		return ms;
//	}
	
	@Bean
	public ReloadableResourceBundleMessageSource messageSource() {
		ReloadableResourceBundleMessageSource  ms = new ReloadableResourceBundleMessageSource();
		ms.setBasenames("classpath:/message/label", "classpath:/errors/error");
		ms.setDefaultEncoding("UTF-8");
		ms.setCacheSeconds(3);
		return ms;
	}
	
	/*
	 * 다국어 처리 
	 * 참고 :
	 * https://url.kr/ef8qbl
	 * 동 https://velog.io/@bey1548/Spring%EC%97%90%EC%84%9C-%EB%8B%A4%EA%B5%AD%EC%96%B4-%EC%A0%81%EC%9A%A9%ED%95%98%EA%B8%B0
	 */
	@Bean
	public SessionLocaleResolver localeResolver() {
		return new SessionLocaleResolver();
	}
	
	@Bean
	public LocaleChangeInterceptor localeChangeInterceptor() {
		LocaleChangeInterceptor interceptor = new LocaleChangeInterceptor();
		interceptor.setParamName("lang");
		return interceptor;
	}
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(localeChangeInterceptor());
	}
	
	@Override
	public Validator getValidator() {
		return new RegisterRequestValidator();
	}
	
}
