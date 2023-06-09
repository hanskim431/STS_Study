package spring.service;

import org.springframework.transaction.annotation.Transactional;

import lombok.AllArgsConstructor;
import spring.dao.Member;
import spring.dao.MemberDao;
import spring.dao.MemberDaoMariaDB;
import spring.domain.MemberDTO;
import spring.exception.DuplicateMemberException;

@AllArgsConstructor
public class MemberRegisterService {

	private MemberDao memberDao;
	
	@Transactional // 두번의 변경이 일어나지 않지만 sql 문 두번 일어났기 떄문에 붙여도 무방하다.
	public void register(MemberDTO dto) {
		// email 중복 여부
		Member member = memberDao.selectByEmail(dto.getEmail());
		if(member!=null) {
			throw new DuplicateMemberException("이미 가입된 이메일입니다. : " + dto.getEmail());
		}
		Member newMember = new Member(dto.getEmail(), dto.getPassword(), dto.getName());
		memberDao.insert(newMember);
	}
}
