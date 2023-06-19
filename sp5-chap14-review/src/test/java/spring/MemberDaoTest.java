package spring;

import java.time.LocalDateTime;
import java.util.List;

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
	public void testSelectByRegdate() {
		List<Member> list = memberDao.selectByRegdate(LocalDateTime.of(2023, 1, 10, 0, 0), LocalDateTime.of(2023, 6, 20, 0, 0));
		
//		System.out.println(list);
		
		list.forEach(e->System.out.println(e.getName()));
	}

}
