package spring.dao;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import spring.domain.Member;

public class MemberDaoTest {

	MemberDao memberDao;
	
	@Before
	public void init() {
		memberDao = new MemberDao();
	}
	
	@Test
	public void test() {
		System.out.println(memberDao.selectAll());
	}
	
	@Test
	@Ignore
	public void testSellectByEmail() {
		
		Member member = memberDao.selectByEmail("go@test.com");
		assertNotNull(member);
		assertNull(member);
		
	}
	
	@Test
	@Ignore
	public void testInsert() {
		
		Member member = new Member("goku@test.com","3333","���");
		member.setRegisterDate(new Date());
		memberDao.insert(member);
		Member findMember = memberDao.selectByEmail(member.getEmail());
		System.out.println(findMember);
	}
	
	@Test
	@Ignore
	public void testUpdate() {
		Member findMember = memberDao.selectByEmail("go@test.com"); // ��ȸ
		findMember.setPassword("9999"); // ��й�ȣ ����
		memberDao.update(findMember); // ����ó��
		findMember = memberDao.selectByEmail("go@test.com"); // �� ��ȸ
		System.out.println(findMember); // ���� ���� Ȯ��
	}
}
