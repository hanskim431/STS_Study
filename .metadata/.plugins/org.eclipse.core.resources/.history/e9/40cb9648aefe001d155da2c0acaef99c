package sample;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class MemberService {

	private MemberDao memberDao;
	
	public MemberService() {}
	
	@Autowired
	public MemberService(@Qualifier("mDao") MemberDao memberDao) {
		this.memberDao = memberDao;
	}
	
	public void info() {
		memberDao.memberInfo();
	}
	
}
