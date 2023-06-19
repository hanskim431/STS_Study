package spring;

import java.time.LocalDateTime;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import config.MemberConfig;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {MemberConfig.class})
public class MemberDaoTest {

	@Autowired
	private MemberDao memberDao;
	
	@Test
	@Ignore
	public void test() {
		List<Member> list = memberDao.selectByRegdate(LocalDateTime.of(2023, 6, 10, 0, 0), 
		LocalDateTime.of(2023, 6, 21, 0, 0));
		System.out.println(list);
		list.forEach(e->System.out.println(e.getName()));
	}

	@Test
	public void testSelectById() {
		Member member = memberDao.selectById(1L);
		System.out.println(member);
		Member member2 = memberDao.selectById(111L);
		System.out.println(member2);
	}
}
