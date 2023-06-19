package config;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;

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
	
	// 인터셉터 등록
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(authCheckInterceptor())
		.addPathPatterns("/edit/**")
			.excludePathPatterns("/edit/help/**"); //제외할 경로 패턴
	}
	
	@Bean
	public AuthCheckInterceptor authCheckInterceptor() {
		return new AuthCheckInterceptor();
	}

	// 날짜 형식 변환 처리 : 기본 적용 설정
	@Override
	public void extendMessageConverters(List<HttpMessageConverter<?>> converters) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy년 MM월 dd일 HH시 mm분 ss초"); // DateTimeFormatter객체 생성, 시간 형식 포멧 지정
		ObjectMapper objectMapper = Jackson2ObjectMapperBuilder // Jackson2ObjectMapperBuilder : ObjectMapper를 쉽게 작성할 수 있도록 sp에서 제공하는 클래스
				.json() // JSON 형식으로 변환
//				.simpleDateFormat("yyyy년 MM월 dd일 HH시 mm분 ss초") // 괄호안의 포멧으로
				.serializerByType(LocalDateTime.class, new LocalDateTimeSerializer(formatter)) // LocalDateTime 타입을 지정된 시간 포멧으로 직렬화 
				.build(); // ObjectMapper 객체 생성, 날짜 형식 설정
		converters.add(0, new MappingJackson2HttpMessageConverter(objectMapper)); // 새로 추가한 HttpMessageConverter를 converter의 목록 제일 앞에 위치
	}
	
}
