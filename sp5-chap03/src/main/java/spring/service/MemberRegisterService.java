package spring.service;

import java.util.Date;

import spring.dao.MemberDao;
import spring.domain.Member;
import spring.domain.dto.RegisterRequest;

// MemberRegisterService�� MemberDao�� ��� : ���� ����
// �ܺηκ��� ���� : ������, ������ �޼ҵ�
public class MemberRegisterService {

	private MemberDao memberDao;

	public MemberRegisterService(MemberDao memberDao) {
		this.memberDao = memberDao;
	}

	public void register (RegisterRequest req) {
		Member member = memberDao.selectByEmail(req.getEamil());
		if(member!=null) { // �̹� ���Ե� �̸����̸� ���� �߻�
			throw new AlreadyExistingMemberException("�̹� ���� �̸����Դϴ�. : " + req.getEamil());
		}
		
		// ���Ե��� ���� �̸����̸� insert() �޼��� ����
		Member newMember = new Member(req.getEamil(), req.getPassword(), req.getName());
		newMember.setRegisterDate(new Date());
		memberDao.insert(newMember);
		
	
	}
}
