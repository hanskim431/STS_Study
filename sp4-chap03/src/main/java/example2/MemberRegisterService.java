package example2;

public class MemberRegisterService {

//	private MemberRepository memberRepository = new MemberRepository(); // ���� ����
	
	// MemberRegisterService�� MemberDao(interface)�� �����Ѵ�
	// MemberRegisterService�� MemberDao�� ����ü�� ���� �� �Ѵ�.
	
	private MemberDao memberDao; 

	public  MemberRegisterService(MemberDao memberDao) {
		this.memberDao = memberDao;
	}

	public void register(String memberInfo) {
		memberDao.selectByEmail("123@naver.com"); // �̸��� �ߺ� �˻�
		memberDao.insert(memberInfo); // ȸ�� ���
		
		System.out.println("ȸ�� ���");
	}
}
