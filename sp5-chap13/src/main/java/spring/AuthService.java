package spring;

import org.springframework.beans.factory.annotation.Autowired;

public class AuthService {

	@Autowired
	private MemberDao memberDao;
	
	public void setMemberDao(MemberDao memberDao) {
		this.memberDao = memberDao;
	}

	public AuthInfo authenticate (String email, String password) {
		Member member = memberDao.selectByEmail(email);
		if(member==null || (!member.matchPassword(password))) { 
			// if((!member.matchPassword(password)) || member==null) 일 때 NullPointError가 발생할 수 있음
			throw new WrongIdPasswordException();
		}
		return new AuthInfo(member.getId(), member.getEmail(), member.getName());
	}
}
