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
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in)); // Ű����� �Է� �� ���� ���ڿ��� �о����
		
		while(true) {
			System.out.print("��ɾ �Է��ϼ��� : ");
			String command = reader.readLine();
			if(command.equalsIgnoreCase("exit")) {
				System.out.println("���α׷��� �����մϴ�.");
				break;
			} else if (command.startsWith("new ")) { // .startsWith("param") : param���� �����ϸ� true
				// ȸ�� ���� new email name pwd confiemPwd
				String[] memberInfo = command.split(" "); // ���ڿ��� �����ڷ� �и��Ͽ� �迭�� �����.
				processNewCommand(memberInfo); 
				continue;
			} else if (command.startsWith("change ")) {
				String[] memberInfo = command.split(" "); // ���ڿ��� �����ڷ� �и��Ͽ� �迭�� �����.
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
		if(memberInfo.length!=4) { // �Է°� �˻�
			printHelp();
			return;
		} 
		 
		// ��ü �����⿡�� ��ü�� ������
//		ChangePasswordService changePasswordService = assembler.getChangePasswordService();
		ChangePasswordService changePasswordService = ctx.getBean(ChangePasswordService.class);
		
		try {
			changePasswordService.changePassword(memberInfo[1], memberInfo[2], memberInfo[3]);
			System.out.println("��й�ȣ�� ���������� ����Ǿ����ϴ�.");
			System.out.println();
		} catch (MemberNotFoundException e) {
			System.out.println("�������� �ʴ� ����� �̸����Դϴ�.");
			System.out.println();
		} catch (IdPasswordNotMatchException e) {
			System.out.println("�̸��ϰ� ��й�ȣ�� ��ġ���� �ʽ��ϴ�.");
			System.out.println();
		} catch (Exception e) {
			System.out.println("�ý��� ����");
			e.printStackTrace();
		}
	}

	private static void processNewCommand(String[] memberInfo) {
		// new email name pwd confirmPwd
		if(memberInfo.length!=5) { // �Է°� �˻�
			printHelp();
			return;
		} 

		// �Է°��� RegisterRequest �� ���� 
		RegisterRequest registerRequest = new RegisterRequest();
		registerRequest.setEamil(memberInfo[1]);
		registerRequest.setName(memberInfo[2]);
		registerRequest.setPassword(memberInfo[3]);
		registerRequest.setConfirmPassword(memberInfo[4]);
		
		// ��й�ȣ ��ġ���� �˻�
		if(!registerRequest.isPasswordEqualToConfirmPassword()) { // ��й�ȣ�� ��ġ���� �ʴ� ���
			System.out.println("��й�ȣ�� ��й�ȣ Ȯ���� ��ġ���� �ʽ��ϴ�.");
			return; // �޼ҵ� ����
		}
		
//		MemberRegisterService memberRegisterService = assembler.getMemberRegisterService();
		MemberRegisterService memberRegisterService = ctx.getBean(MemberRegisterService.class);
		
		try {
			memberRegisterService.register(registerRequest);
			System.out.println();
			System.out.println("## ȸ������ ���� ##");
			System.out.println();
			
		} catch (AlreadyExistingMemberException e) {
			System.out.println(e.getMessage());
		}
		// ��й�ȣ�� ��ġ�ϴ� ��� : ��� ó��
	}

	private static void printHelp() {
		System.out.println();
		System.out.println("=====================================================================");
		System.out.println("�߸��� ��ɾ��Դϴ�. �Ʒ� ������ Ȯ���ϼ���.");
		System.out.println("[ȸ������] : new �̸��� �̸� ��й�ȣ ��й�ȣȮ��");
		System.out.println("[��й�ȣ����] : change �̸��� �����й�ȣ ��й�ȣȮ��");
		System.out.println("[���ȸ������] : list");
		System.out.println("[ȸ��������ȸ] : info �̸���");
		System.out.println("[����������ȸ] : version");
		System.out.println("=====================================================================");
		System.out.println();
	} 
}
