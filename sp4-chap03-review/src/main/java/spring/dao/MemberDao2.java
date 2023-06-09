package spring.dao;

public class MemberDao2 implements IMemberDao{

	public void insert() {
		System.out.println("회원등록2");
	}
	
	public void update() {
		System.out.println("비밀번호변경2");
	}
}
