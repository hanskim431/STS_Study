package spring.dao;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:appCtx.xml"})
public class MemberDaoTest {

	@Autowired
	MemberDao memberDao;
	
	@Test
	@Ignore
	public void testSelectAll() {
		assertNotNull(memberDao);
		List<Member> list = memberDao.selectAll();
		System.out.println(list);
	}
	
	@Test
//	@Ignore
	public void testSelectByEmailTrue() {
		assertNotNull(memberDao);
		Member member = memberDao.selectByEmail("go@test.com");
//		assertEquals("��ö��", member.getName());
//		assertEquals(2L, member.getId().longValue());
		System.out.println(member);
	}
	
	@Test
	@Ignore
	public void testSelectByEmailFalse() {
		assertNotNull(memberDao);
		Member member = memberDao.selectByEmail("go@test.com");
		System.out.println(member);
	}
	
	@Test
	@Ignore
	public void testInsert() {
		Member member = new Member("go@test.com", "3333", "������");
		memberDao.insert(member);
		
		Member findMember = memberDao.selectByEmail(member.getEmail());
		assertEquals(member.getEmail(), findMember.getEmail());
		assertEquals(member.getName(), findMember.getName());
		assertEquals(member.getPassword(), findMember.getPassword());
		assertEquals(3L, findMember.getId().longValue());
	}
	
	@Test
	@Ignore
	public void testUpdate() {
		Member member = new Member("go@test.com", "9999", "������");
		memberDao.update(member);
		
		Member findMember = memberDao.selectByEmail(member.getEmail());
		assertEquals(member.getEmail(), findMember.getEmail());
		assertEquals(member.getName(), findMember.getName());
		assertEquals(member.getPassword(), findMember.getPassword());
		assertEquals(3L, findMember.getId().longValue());
	}
}
