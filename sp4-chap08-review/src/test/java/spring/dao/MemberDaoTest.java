package spring.dao;

import static org.junit.Assert.assertNotNull;

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

	// LIST ����Ʈ
	@Test
	@Ignore
	public void testList() {
		assertNotNull(memberDao);
		List<Member> list = memberDao.selectAll();
		System.out.println(list);
	}

	// C ����
	@Test
	@Ignore
	public void testInsert() {
		assertNotNull(memberDao);
		Member member = new Member("kong@test.com", "2222", "ȫ��ȣ");
		memberDao.insert(member);
		
	}

	// R �б�
	@Test
	@Ignore
	public void testRead() {
		assertNotNull(memberDao);
		Member member = memberDao.selectByEmail("go@test.com");
		System.out.println(member);
	}
	
	// U ����
	@Test
	@Ignore
	public void testUpdate() {
		assertNotNull(memberDao);
		Member member = new Member("kong@test.com", "9999", "ȫ��ȣ");
		memberDao.update(member);
	}
	
	// D ����
	@Test
//	@Ignore
	public void testRemove() {
		assertNotNull(memberDao);
		memberDao.delete("kong@test.com");
	}
	
}
