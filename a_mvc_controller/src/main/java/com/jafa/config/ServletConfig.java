package com.jafa.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.jafa.controller.HomeController;

// @Configuration : 스프링 어노테이션, 해당 클래스가 애플리케이션의 구성(Configuation)을 담당하는 클래스임을 표시 
	//  @Configuration 어노테이션이 지정된 클래스는 스프링 bean 설정을 포함, 이를 통해 application의 다양한 구성 요소를 정의하고 관리.
	
// @EnableWebMvc : 스프링 MVC를 활성화하기 위한 어노테이션
	// - WebMvcConfigurer interface를 구현한 bean들이 자동으로 등록됨, 이로 스프링 MVC의 다양한 설정을 구성할 수 있음.
	// - DefaultAnnotationHandlerMapping, RequestMappingHandlerAdapter, ExceptionHandlerExceptionResolver 
	// 등과 같은 핸들러 매핑과 핸들러 어댑터, 예외 처리 등의 빈이 자동으로 등록
	// - 정적 리소스(css, image, 자바 스크립트) 처리를 위한 기본 핸들러가 등록됨. 
	// - 웹 어플리케이션의 컨트롤러, 뷰, 리졸버, 예외 처리, 데이터 바인딩등을 구성할 수 있게함.
	
//@ComponentScan : 스프링 프레임워크에서 컴포넌트 스캐닝을 수행하기위한 어노테이션
	// @ComponentScan("com.jafa")일 때, com.jafa 패키지와 그 하위 패킹지를 스캔하여 스프링 빈으로 등록
	// 패키지 내에 @Component 어노테이션이 붙은 클래스는 자동으로 인식하고 bean으로 등록. (무엇인지는 아래 참고)
	// 스캔된 컴포넌트들은 스프링 컨테이너에서 관리, 필요한 곳에서 주입받아 사용 가능.
	// 스프링 앱 컨텍스트가 시작될 때, 자동으로 스캔을 수행해 @Component 어노테이션을 사용하여 지정하면 스프링은 해당 패키지 내의 컴포넌트를 스캔하여 빈으로 등록함.

@Configuration
@EnableWebMvc
@ComponentScan("com.jafa") // RootConfig에다 하면 bean을 불러오지 못함. 
public class ServletConfig implements WebMvcConfigurer{

	@Override
	public void configureViewResolvers(ViewResolverRegistry registry) {
		registry.jsp("/WEB-INF/views/", ".jsp"); // jsp 뷰 리졸버 등록, jsp파일 경로 설정
	}
	// jsp() 메서드를 호출하여 JSP 뷰 리졸버를 등록하고, "/WEB-INF/views/"를 prifix로 지정하여 JSP파일 경로를 설정
	// .jsp를 suffix로 지정하여 JSP 파일의 확장자를 설정
	// 컨트롤러에서 반환하는 뷰 이름을 기반으로 실제 JSP파일의 경로를 매핑하여 뷰를 랜더링함.
	// ex) 컨트롤러에서 return "home"; 을 반환하면 /WEB-INF/views/home.jsp 파일을 찾아서 랜더링함


//	// css, image, 자바 스크립트 처리하기 위함
//	@Override
//	public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
//		configurer.enable();
//	}
	
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/resources/**") // resources 이하의 "모든" 요청에 대하여 디스패쳐 서블릿이 관여하지 않음, 웹 서버가 직접 제공 (성능 향상)
			.addResourceLocations("/resources/"); // /resources/** 패턴의 요청을 /resources/ 경로의 실제 리소스와 매핑
	}
	// addResourceHandler 메서드는 정적 리소스의 핸들러를 등록하는 역할
	// ResourceHandlerRegistry를 사용하여 정적 리소스의 핸들러 등록
	// addResourceHandler() 메서드를 사용하여 실제 리소스의 경로 지정
	
	@Bean
	public HomeController homeController() {
		return new HomeController();
	}
}

/*  @ConponentScan이 검색가능한 빈
 *  	@Component가 붙은 클래스
 *  	@Controller
 *  	@Configuration
 *  	@Service
 * 		@Repositiry
 * 
 *	@Component를 가지고 있는 클래스라면 불러올 수 있음. 
 */ 
