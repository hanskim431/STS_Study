package spring.dao;

public class MemberDao implements IMemberDao{

	public void insert() {
		System.out.println("회원등록");
	}
	
	public void update() {
		System.out.println("비밀번호변경");
	}
}
