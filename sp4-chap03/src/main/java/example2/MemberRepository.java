package example2;

public class MemberRepository implements MemberDao{
	
	@Override
	public void selectByEmail(String email) {
		System.out.println("MemberRepository - �̸��� �ߺ� �˻� : " + email);
	}
	
	@Override
	public void insert(String memberInfo) {
		System.out.println("MemberRepository - ȸ�� ��� : " + memberInfo);
	}

}
