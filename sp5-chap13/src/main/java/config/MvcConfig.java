package config;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import controller.SampleInterceptor;
import interceptor.AuthCheckInterceptor;

@Configuration
@EnableWebMvc
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
	
	
	@Bean
	public MessageSource messageSource() { // 빈id를 반드시 messageSource로 지정해야함
		ResourceBundleMessageSource ms = new ResourceBundleMessageSource(); 
		ms.setBasenames("message.label"); // classpath:message/label.properties
		ms.setDefaultEncoding("UTF-8");
		return ms;
	}
	
	@Bean
	public SampleInterceptor sampleInterceptor() {
		return new SampleInterceptor();
	}
	
	@Bean
	public AuthCheckInterceptor authCheckInterceptor() {
		return new AuthCheckInterceptor();
	}
	
	// 인터셉터 추가
	@Override 
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(authCheckInterceptor()) 
		.addPathPatterns("/edit/**") // 특정 경로 추가, edit 이하 모든 경로
		.excludePathPatterns("/edit/help/**"); //제외할 경로 패턴
		// 테스트용
		registry.addInterceptor(sampleInterceptor())
				.addPathPatterns("/sample/**") // 특정 경로 추가
				.excludePathPatterns("/sample/test1", "/sample/test2");  // 특정 경로 제거
	}
	
}
