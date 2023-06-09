package spring.service;

import static org.junit.Assert.*;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import spring.domain.MemberDTO;
import spring.exception.DuplicateMemberException;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:appCtx.xml"})
public class MemberRegisterServiceTest {

	@Autowired
	MemberRegisterService memberRegisterService;
	
	@Test
	@Ignore
	public void testRegister() {
		MemberDTO dto = new MemberDTO();
		dto.setEmail("go@test.com");
		dto.setPassword("1111");
		dto.setConfirmPassword("1111");
		dto.setName("°í¿µÈñ");
		memberRegisterService.register(dto);
	}
	
	@Test(expected = DuplicateMemberException.class)
	public void testRegisterDupl() {
		MemberDTO dto = new MemberDTO();
		dto.setEmail("go@test.com");
		dto.setPassword("1111");
		dto.setConfirmPassword("1111");
		dto.setName("°í¿µÈñ");
		memberRegisterService.register(dto);
	}

	
}
