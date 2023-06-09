package example2;

public class MemberDaoImpl2 implements MemberDao{
	
	@Override
	public void selectByEmail(String email) {
		System.out.println("구현중");
	}

	@Override
	public void insert(String memberInfo) {
		System.out.println("구현중");
	}

}
