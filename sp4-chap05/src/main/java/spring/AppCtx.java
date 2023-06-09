package spring;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
//@ComponentScan(basePackages = {"spring.dao","spring.service"})

// AppCtx �� ���� ������ ��� ��Ű���� ������Ʈ�μ� �˻��Ѵ�
@ComponentScan(basePackageClasses = {AppCtx.class})
public class AppCtx {

}
