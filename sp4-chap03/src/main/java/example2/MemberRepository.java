package example2;

public class MemberRepository implements MemberDao{
	
	@Override
	public void selectByEmail(String email) {
		System.out.println("MemberRepository - 이메일 중복 검사 : " + email);
	}
	
	@Override
	public void insert(String memberInfo) {
		System.out.println("MemberRepository - 회원 등록 : " + memberInfo);
	}

}
