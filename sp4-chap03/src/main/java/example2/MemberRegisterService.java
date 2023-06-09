package example2;

public class MemberRegisterService {

//	private MemberRepository memberRepository = new MemberRepository(); // 직접 생성
	
	// MemberRegisterService는 MemberDao(interface)에 의존한다
	// MemberRegisterService는 MemberDao의 구현체를 알지 못 한다.
	
	private MemberDao memberDao; 

	public  MemberRegisterService(MemberDao memberDao) {
		this.memberDao = memberDao;
	}

	public void register(String memberInfo) {
		memberDao.selectByEmail("123@naver.com"); // 이메일 중복 검사
		memberDao.insert(memberInfo); // 회원 등록
		
		System.out.println("회원 등록");
	}
}
