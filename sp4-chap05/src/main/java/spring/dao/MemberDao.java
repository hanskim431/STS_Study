package spring.dao;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import spring.domain.Member;

@Component
public class MemberDao {

	private static Long nextId = 2L; // 2�� ���Ե��� ����
	
	// Map<key, value> Ű-�� �� : Ű(����) ��(�ߺ���)
	private Map<String, Member> map = new HashMap<>(); // DB ������� map�� �̿���
	
	public MemberDao() { 
		Member member1 = new Member("go@test.com","1111","����");
		member1.setId(1L);
		member1.setRegisterDate(new Date());
		
		Member member2 = new Member("stop@test.com","2222","������");
		member2.setId(2L);
		member2.setRegisterDate(new Date());
		map.put(member1.getEmail(), member1);
		map.put(member2.getEmail(), member2);

//		Member member3 = new Member("stop@test.com","3333","����2��");
//		member3.setId(3L);
//		member3.setRegisterDate(new Date());
//		map.put(member3.getEmail(), member3);
		// �̷������� Map�� Key �� �ߺ����� ����ؼ� �����͸� ������ ������ �־��� �����Ͱ� ��ü��	
		// ��°� :
		// [Member [id=1,email=go@test.com,password=1111,name=����,registerDate=Fri May 26 10:50:10 KST 2023], Member [id=3,email=stop@test.com,password=3333,name=����2��,registerDate=Fri May 26 10:50:10 KST 2023]]
 
		
	}
	
	
	public Member selectByEmail(String email) {
		return map.get(email);
	}
	
	// ��� ȸ�� ����
	public List<Member> selectAll() {
		// (Collection<? extends E> E �Ǵ� E�� ����� ��ü Ÿ��, E�� ����Ÿ���� �Ұ�
		// (Collection<? super E> E �Ǵ� E�� ����Ÿ��, E�� ����� ��ü Ÿ���� �Ұ�
		// (Collection<? extends Member> : Member �Ǵ� Member�� ����� ��ü, Member�� ����ü�� ������ �� ����.
		// (Collection<? super Member> Member �Ǵ� Member�� ����Ÿ��, Member�� ����� ��ü Ÿ���� �Ұ�
		Collection<Member> values = map.values();
		List<Member> memberList = new ArrayList<>(values);
		
		return memberList;
		
	}
	
	// ȸ�� ����
	public void insert(Member member) {
		member.setId(++nextId);
		map.put(member.getEmail(), member);
	}
	
	// ȸ�� ����
	public void update(Member member) {
		map.put(member.getEmail(), member);
	}
	
}
