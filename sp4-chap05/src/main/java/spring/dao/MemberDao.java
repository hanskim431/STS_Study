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

	private static Long nextId = 2L; // 2명 가입됨을 가정
	
	// Map<key, value> 키-값 쌍 : 키(유일) 값(중복가)
	private Map<String, Member> map = new HashMap<>(); // DB 구현대신 map을 이용함
	
	public MemberDao() { 
		Member member1 = new Member("go@test.com","1111","고영희");
		member1.setId(1L);
		member1.setRegisterDate(new Date());
		
		Member member2 = new Member("stop@test.com","2222","정지훈");
		member2.setId(2L);
		member2.setRegisterDate(new Date());
		map.put(member1.getEmail(), member1);
		map.put(member2.getEmail(), member2);

//		Member member3 = new Member("stop@test.com","3333","정지2훈");
//		member3.setId(3L);
//		member3.setRegisterDate(new Date());
//		map.put(member3.getEmail(), member3);
		// 이런식으로 Map의 Key 를 중복으로 사용해서 데이터를 넣으면 이전에 넣었던 데이터가 대체됨	
		// 출력값 :
		// [Member [id=1,email=go@test.com,password=1111,name=고영희,registerDate=Fri May 26 10:50:10 KST 2023], Member [id=3,email=stop@test.com,password=3333,name=정지2훈,registerDate=Fri May 26 10:50:10 KST 2023]]
 
		
	}
	
	
	public Member selectByEmail(String email) {
		return map.get(email);
	}
	
	// 모든 회원 정보
	public List<Member> selectAll() {
		// (Collection<? extends E> E 또는 E를 상속한 객체 타입, E의 조상타입은 불가
		// (Collection<? super E> E 또는 E의 조상타입, E를 상속한 객체 타입은 불가
		// (Collection<? extends Member> : Member 또는 Member를 상속한 객체, Member의 조상객체는 대입할 수 없다.
		// (Collection<? super Member> Member 또는 Member의 조상타입, Member를 상속한 객체 타입은 불가
		Collection<Member> values = map.values();
		List<Member> memberList = new ArrayList<>(values);
		
		return memberList;
		
	}
	
	// 회원 가입
	public void insert(Member member) {
		member.setId(++nextId);
		map.put(member.getEmail(), member);
	}
	
	// 회원 수정
	public void update(Member member) {
		map.put(member.getEmail(), member);
	}
	
}
