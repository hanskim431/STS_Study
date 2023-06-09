package config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import controller.HelloController;

@Configuration
public class ControllerConfig {

	@Autowired
	private HelloController helloController;
}
