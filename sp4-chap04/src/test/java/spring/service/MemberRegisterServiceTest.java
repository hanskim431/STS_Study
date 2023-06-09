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
	
	// ���Ե� �̸����� ���� ���
	@Test
	@Ignore
	public void testRegisterSuccece() {
		RegisterRequest request = new RegisterRequest();
		request.setEamil("go1@test.com");
		request.setPassword("1234");
		request.setName("����");
		service.register(request);
		
		Member findMember = dao.selectByEmail("go1@test.com");
		assertNotNull(findMember);
		System.out.println(findMember);
	}

	
	// ���Ե� �̸����� �ִ� ���
	@Test(expected = AlreadyExistingMemberException.class)
//	@Test
	public void testRegisterFailed() {
		RegisterRequest request = new RegisterRequest();
		request.setEamil("go@test.com");
		service.register(request);
		
	}
}
