package spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import spring.dao.Member;
import spring.dao.MemberDao;
import spring.exception.MemberNotFoundException;

public class MemberRemoveService {
	
	@Autowired
	private MemberDao memberDao;
	
	@Transactional // 두번의 변경이 일어나지 않지만 sql 문 두번 일어났기 떄문에 붙여도 무방하다.
	public void remove(String email) {
		// 우선 삭제할 대상이 존재하는 지 selectByEmail로 검색 후 Member 정보를 findMember에 대입
		Member findMember = memberDao.selectByEmail(email);
		if(findMember==null) { // 삭제할 대상이 없다, findMember가 null이다
			throw new MemberNotFoundException();
		}
		memberDao.delete(email);
		System.out.println("ȸ�� ������ : " + email);
	}
}
