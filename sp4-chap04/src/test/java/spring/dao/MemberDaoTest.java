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
		
		Member member = new Member("goku@test.com","3333","빅부");
		member.setRegisterDate(new Date());
		memberDao.insert(member);
		Member findMember = memberDao.selectByEmail(member.getEmail());
		System.out.println(findMember);
	}
	
	@Test
	@Ignore
	public void testUpdate() {
		Member findMember = memberDao.selectByEmail("go@test.com"); // 조회
		findMember.setPassword("9999"); // 비밀번호 변경
		memberDao.update(findMember); // 수정처리
		findMember = memberDao.selectByEmail("go@test.com"); // 재 조회
		System.out.println(findMember); // 수정 여부 확인
	}
}
