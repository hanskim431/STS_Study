package service;

import java.util.List;

import dao.MemberDao;
import domain.MemberVO;

public class MemberService {
	
	// MemberDao 객체 생성
	private MemberDao memberDao;
	
	// MemberService 생성자 : 매개변수 memberDao
	public MemberService(MemberDao memberDao) {
		this.memberDao = memberDao;
	}

	// member List 호출 메소드 
	public List<MemberVO> members() {
		return memberDao.list(); 
	}
	
	public MemberVO memberInfo(String email) {
		return memberDao.selectByEmail(email);
	}
	
	public void register(MemberVO vo) {
		MemberVO findMember = memberDao.selectByEmail(vo.getEmail());
		if(findMember!=null) {
			throw new DuplicateMemberException("이미 사용중인 이메일입니다.");
		}
		memberDao.insertKeyHolder(vo);
	}
	
//	// 키 홀더 미사용
//	public void register2(MemberVO vo) {
//		MemberVO findMember = memberDao.selectByEmail(vo.getEmail());
//		if(findMember!=null) {
//			throw new DuplicateMemberException("이미 사용중인 이메일입니다.");
//		}
//		memberDao.insert(vo);
//	}
	
	
}
