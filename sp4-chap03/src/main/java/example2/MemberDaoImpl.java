package example2;

public class MemberDaoImpl implements MemberDao{

	@Override
	public void selectByEmail(String email) {
		System.out.println("MemberDaoImpl : 이메일 중복 검사 : " + email);
	}

	@Override
	public void insert(String memberInfo) {
		System.out.println("MemberDaoImpl : 회원 등록 : " + memberInfo);
	}

}
