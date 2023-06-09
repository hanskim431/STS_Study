package spring;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
//@ComponentScan(basePackages = {"spring.dao","spring.service"})

// AppCtx 가 속한 이하의 모든 패키지를 컴포넌트로서 검색한다
@ComponentScan(basePackageClasses = {AppCtx.class})
public class AppCtx {

}
