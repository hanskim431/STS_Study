package spring.service;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import spring.dao.MemberDao;
import spring.domain.Member;
import spring.domain.dto.RegisterRequest;

public class MemberRegisterServiceTest {

	private MemberRegisterService service;
	private MemberDao dao;
	@Before
	public void setUp() {
		dao = new MemberDao();
		service = new MemberRegisterService(dao);
	}
	
	// 가입된 이메일이 없는 경우
	@Test
	@Ignore
	public void testRegisterSuccece() {
		RegisterRequest request = new RegisterRequest();
		request.setEamil("go1@test.com");
		request.setPassword("1234");
		request.setName("고일");
		service.register(request);
		
		Member findMember = dao.selectByEmail("go1@test.com");
		assertNotNull(findMember);
		System.out.println(findMember);
	}

	
	// 가입된 이메일이 있는 경우
	@Test(expected = AlreadyExistingMemberException.class)
//	@Test
	public void testRegisterFailed() {
		RegisterRequest request = new RegisterRequest();
		request.setEamil("go@test.com");
		service.register(request);
		
	}
}
