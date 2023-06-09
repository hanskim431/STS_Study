package dao;

import static org.junit.Assert.*;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;

import config.AppTest;
import domain.MemberVO;

public class MemberDaoTest extends AppTest {

	@Autowired
	private MemberDao memberDao;
	
	@Test
	@Ignore
	public void test() {
		memberDao.list();
	}
	
	@Test
	@Ignore
	public void testSelectByEmail() {
		MemberVO vo = memberDao.selectByEmail("go@test.com");
		System.out.println(vo);
	}
	
	@Test
	@Ignore
	public void testSelectByEmailFail() {
		MemberVO vo = memberDao.selectByEmail("gone@test.com");
		System.out.println(vo);
	}

	@Test
	@Ignore
	public void testInsert() {
		MemberVO vo = new MemberVO();
		vo.setEmail("email");
		vo.setName("name");
		vo.setPassword("pwd");
		memberDao.insert(vo);
	}
	
	@Test
	public void testInsertKeyHolder() {
		MemberVO vo = new MemberVO();
		vo.setEmail("email");
		vo.setName("name");
		vo.setPassword("pwd");
		Long memberId = memberDao.insertKeyHolder(vo);
		System.out.println(memberId);
	}
}
