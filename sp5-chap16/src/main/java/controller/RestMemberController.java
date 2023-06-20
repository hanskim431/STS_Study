package controller;

import java.io.IOException;
import java.net.URI;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.jboss.logging.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import spring.DemoBean;
import spring.Member;
import spring.MemberDao;
import spring.MemberNotFoundException;
import spring.MemberRegisterService;
import spring.RegisterRequest;

@RestController
//@Controller
//@ResponseBody
public class RestMemberController {

	private MemberDao memberDao;
	
	private MemberRegisterService memberRegisterService;
	
	public void setMemberDao(MemberDao memberDao) {
		this.memberDao = memberDao;
	}
	
	public void setMemberRegisterService(MemberRegisterService memberRegisterService) {
		this.memberRegisterService = memberRegisterService;
	}
	
	@GetMapping("/api/members")
	public List<Member> members() {
		return memberDao.selectAll();
	}
	
	// id로 멤버 찾기
	@GetMapping("/api/members/{id}")
	public Member member(@PathVariable("id") Long id) throws IOException {
//		public Member member(@PathVariable("id") Long id, HttpServletResponse response) throws IOException {
		Member member = memberDao.selectById(id);
		if(member==null) {
//			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ErrorResponse("no member"));
			throw new MemberNotFoundException();
		}
//		return ResponseEntity.status(HttpStatus.OK).body(member);
		return member;
	}
	
	@GetMapping("/api/demo")
	public DemoBean demoTest() {
		DemoBean demoBean = new DemoBean();
		demoBean.setRegDate(new Date()); // 70년부터 ms 단위
		return demoBean;
	}

	@Autowired
	MessageSource messageSource;
	
	@PostMapping("/api/members")
	public ResponseEntity<Object> newMember(@RequestBody @Valid RegisterRequest registerRequest, Errors errors) throws IOException {
//		public void newMember(@RequestBody @Valid RegisterRequest registerRequest, HttpServletResponse response) throws IOException {
//		new RegisterRequestValidator().validate(registerRequest, error);
//		if(error.hasErrors()) {
//			response.sendError(HttpServletResponse.SC_BAD_REQUEST);
//			return;
//		} // @Valid 글로벌 valid 쓰면 안 써도 됨
		
		if(errors.hasErrors()) {
			errors.getAllErrors().stream()
			.map(error->error.getCodes()[0]).forEach(code->{
				String message = messageSource.getMessage(code, null, Locale.getDefault());
				System.out.println(code + ":" + message);
			});
			
			String errorCode = errors.getAllErrors().stream()
			.map(error->error.getCodes()[0])
			.collect(Collectors.joining(","));
			
			String errorCode2 = errors.getAllErrors().stream()
			.map(error->messageSource.getMessage(error.getCodes()[0], null, Locale.getDefault()))
			.collect(Collectors.joining(","));
			
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ErrorResponse(errorCode));
		}
		try {
			Long newMemberId = memberRegisterService.regist(registerRequest);
			URI uri = URI.create("/api/members"+newMemberId);
//			response.setStatus(HttpServletResponse.SC_CREATED); // (1)
//			response.setHeader("Location", "/api/members"+newMemberId); // (1)
			
//			return ResponseEntity.status(HttpStatus.CREATED).build(); // (2)
			return ResponseEntity.created(uri).build(); // (2) 201 응답과 동시에 header의 location값 설정
		} catch (Exception e) {
//			respsonse.sendError(HttpServletResponse.SC_CONFLICT); // (1)
//			return new ResponseEntity<Object>(HttpStatus.CONFLICT); // (2)
			return ResponseEntity
					.status(HttpStatus.CONFLICT)
					.body(new ErrorResponse("duplicate")); // (2)-1
		}
	}
}


/*
	JSON 응답과 요청 처리
	토픽 : 
	
	JSON = 메시지 전송 형식
	- GOOD : 데이터 구조 유연(DB 수정 X), 복잡한 데이터 처리, 확장성과 호환성(다양한 프로그래밍 언어)
	- BAD : 성능, 쿼리 제한, 데이터 무결성 유지
	
	 Jackson = JAVA 객체와 JSON간의 상호 변환용 JAVA 라이브러리
	- 
	- 
	
	@RestController = @Controller + @ResponseBody (after sp4)
	
	@JsonIgnore = 제외 처리 (password 등)
	
	@JsonFormat(shape=Shape.STRING), @JsonFormat(pattern="yyyy년MM월dd일 HH시mm분ss초") = 날짜 형식 변환
	서버 API
*/