package example2;

public class MemberDaoImpl implements MemberDao{

	@Override
	public void selectByEmail(String email) {
		System.out.println("MemberDaoImpl : �̸��� �ߺ� �˻� : " + email);
	}

	@Override
	public void insert(String memberInfo) {
		System.out.println("MemberDaoImpl : ȸ�� ��� : " + memberInfo);
	}

}
