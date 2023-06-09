package spring.main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import spring.config.AppConfig;
import spring.domain.dto.RegisterRequest;
import spring.exception.IdPasswordNotMatchException;
import spring.exception.MemberNotFoundException;
import spring.service.AlreadyExistingMemberException;
import spring.service.ChangePasswordService;
import spring.service.MemberInfoPrinter;
import spring.service.MemberListPrinter;
import spring.service.MemberRegisterService;
import spring.service.VersionPrinter;

public class Main2 {
	
	public static ApplicationContext ctx = new GenericXmlApplicationContext("classpath:conf1.xml"); 
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in)); // 키보드로 입력 한 값을 문자열로 읽어오는
		
		while(true) {
			System.out.print("명령어를 입력하세요 : ");
			String command = reader.readLine();
			if(command.equalsIgnoreCase("exit")) {
				System.out.println("프로그램을 종료합니다.");
				break;
			} else if (command.startsWith("new ")) { // .startsWith("param") : param으로 시작하면 true
				// 회원 가입 new email name pwd confiemPwd
				String[] memberInfo = command.split(" "); // 문자열을 구분자로 분리하여 배열로 만든다.
				processNewCommand(memberInfo); 
				continue;
			} else if (command.startsWith("change ")) {
				String[] memberInfo = command.split(" "); // 문자열을 구분자로 분리하여 배열로 만든다.
				processChangeCommand(memberInfo); 
				continue;
			} else if (command.equals("list")) {
				processListCommend();
				continue;
			} else if (command.startsWith("info ")) {
				processInfoCommand(command.split(" ")); // info go@test.com
			continue;
			} else if (command.equals("version")) {
				processVersionCommand();
			continue;
			} 
			printHelp();
		}
	} // main-END

	private static void processVersionCommand() {
		VersionPrinter versionPrinter = ctx.getBean(VersionPrinter.class);
		versionPrinter.print();
	}

	private static void processInfoCommand(String[] arg) {
		if(arg.length!=2) {
			printHelp();
			return;
		}
		MemberInfoPrinter memberInfoPrinter = ctx.getBean(MemberInfoPrinter.class);
		memberInfoPrinter.printMemberInfo(arg[1]);
	}

	private static void processListCommend() {
		MemberListPrinter memberListPrinter = ctx.getBean(MemberListPrinter.class);
		memberListPrinter.printAll();
		
	}

	private static void processChangeCommand(String[] memberInfo) {
		// change eamil pwd changePwd
		if(memberInfo.length!=4) { // 입력값 검사
			printHelp();
			return;
		} 
		 
		// 객체 조립기에서 객체를 가져옴
//		ChangePasswordService changePasswordService = assembler.getChangePasswordService();
		ChangePasswordService changePasswordService = ctx.getBean(ChangePasswordService.class);
		
		try {
			changePasswordService.changePassword(memberInfo[1], memberInfo[2], memberInfo[3]);
			System.out.println("비밀번호가 성공적으로 변경되었습니다.");
			System.out.println();
		} catch (MemberNotFoundException e) {
			System.out.println("존재하지 않는 사용자 이메일입니다.");
			System.out.println();
		} catch (IdPasswordNotMatchException e) {
			System.out.println("이메일과 비밀번호가 일치하지 않습니다.");
			System.out.println();
		} catch (Exception e) {
			System.out.println("시스템 오류");
			e.printStackTrace();
		}
	}

	private static void processNewCommand(String[] memberInfo) {
		// new email name pwd confirmPwd
		if(memberInfo.length!=5) { // 입력값 검사
			printHelp();
			return;
		} 

		// 입력값을 RegisterRequest 에 담음 
		RegisterRequest registerRequest = new RegisterRequest();
		registerRequest.setEamil(memberInfo[1]);
		registerRequest.setName(memberInfo[2]);
		registerRequest.setPassword(memberInfo[3]);
		registerRequest.setConfirmPassword(memberInfo[4]);
		
		// 비밀번호 일치여부 검사
		if(!registerRequest.isPasswordEqualToConfirmPassword()) { // 비밀번호가 일치하지 않는 경우
			System.out.println("비밀번호와 비밀번호 확인이 일치하지 않습니다.");
			return; // 메소드 종료
		}
		
//		MemberRegisterService memberRegisterService = assembler.getMemberRegisterService();
		MemberRegisterService memberRegisterService = ctx.getBean(MemberRegisterService.class);
		
		try {
			memberRegisterService.register(registerRequest);
			System.out.println();
			System.out.println("## 회원가입 성공 ##");
			System.out.println();
			
		} catch (AlreadyExistingMemberException e) {
			System.out.println(e.getMessage());
		}
		// 비밀번호가 일치하는 경우 : 등록 처리
	}

	private static void printHelp() {
		System.out.println();
		System.out.println("=====================================================================");
		System.out.println("잘못된 명령어입니다. 아래 사용법을 확인하세요.");
		System.out.println("[회원가입] : new 이메일 이름 비밀번호 비밀번호확인");
		System.out.println("[비밀번호변경] : change 이메일 현재비밀번호 비밀번호확인");
		System.out.println("[모든회원정보] : list");
		System.out.println("[회원정보조회] : info 이메일");
		System.out.println("[버전정보조회] : version");
		System.out.println("=====================================================================");
		System.out.println();
	} 
}
