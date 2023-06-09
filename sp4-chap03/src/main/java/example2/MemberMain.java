package example2;

public class MemberMain {
	public static void main(String[] args) {
		
		MemberDaoImpl memberDaoImpl = new MemberDaoImpl(); // 인텔 CPU
		MemberRepository memberRepository = new MemberRepository(); // AMD CPU
		MemberDaoImpl2 memberDaoImpl2 = new MemberDaoImpl2(); // 인텔 CPU
		
		// MemberDao : CPU
		MemberRegisterService service = new MemberRegisterService(memberDaoImpl); // 메인보드 () = 슬롯
		service.register("홍길동");
		
		
	}
}
