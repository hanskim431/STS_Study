package config;

import javax.servlet.Filter;

import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class WebConfig extends AbstractAnnotationConfigDispatcherServletInitializer{

	@Override
	protected Class<?>[] getRootConfigClasses() {
		return new Class[] {RootConfig.class};
	}

	// spring-mvc.xml -> MvcConfig.java 로 만들어 사용
	@Override
	protected Class<?>[] getServletConfigClasses() {
		return new Class[] {MvcConfig.class, ControllerConfig.class};
	}

	@Override
	protected String[] getServletMappings() {
		return new String[] {"/"};
	}

	// Korean filter
	@Override
	protected Filter[] getServletFilters() {
		CharacterEncodingFilter filter = new CharacterEncodingFilter();
		filter.setEncoding("utf-8");
		filter.setForceEncoding(true);
		
		return new Filter[] {filter};
	}
	
	
}
