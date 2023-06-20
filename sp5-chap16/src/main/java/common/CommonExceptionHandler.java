package common;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import controller.ErrorResponse;
import spring.MemberNotFoundException;

@ControllerAdvice("controller") // spring패키지 이하 컨트롤러에 적용 
public class CommonExceptionHandler {

//	@ExceptionHandler(RuntimeException.class)
//	public String handleRuntimeException() {
//		return "error/commonException";
//	}
	
	@ExceptionHandler(MemberNotFoundException.class)
	public ResponseEntity<ErrorResponse> handlerNoDate() {
		return ResponseEntity.status(HttpStatus.NOT_FOUND)
				.body(new ErrorResponse("회원 정보를 찾을 수 없습니다."));
	}
}
