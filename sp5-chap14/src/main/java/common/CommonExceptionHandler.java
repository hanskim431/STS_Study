package common;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.NoHandlerFoundException;

@ControllerAdvice("controller")
public class CommonExceptionHandler {

	@ExceptionHandler(RuntimeException.class)
	public String handlerRuntimeExcepton() {
		return "error/commonException";
	}
	
	@ExceptionHandler(NoHandlerFoundException.class)
	public String handle404() {
		return "error/notFound";
	}
}
