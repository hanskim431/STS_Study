package example2;

public class MemberMain {
	public static void main(String[] args) {
		
		MemberDaoImpl memberDaoImpl = new MemberDaoImpl(); // ���� CPU
		MemberRepository memberRepository = new MemberRepository(); // AMD CPU
		MemberDaoImpl2 memberDaoImpl2 = new MemberDaoImpl2(); // ���� CPU
		
		// MemberDao : CPU
		MemberRegisterService service = new MemberRegisterService(memberDaoImpl); // ���κ��� () = ����
		service.register("ȫ�浿");
		
		
	}
}
