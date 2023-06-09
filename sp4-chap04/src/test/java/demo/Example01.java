package demo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//  Map 사용법
public class Example01 {
	
	/* 
	 * Map 
	 * key - value 값 쌍으로 이루어짐
	 * {"apple"="사과", "kiwi"="키위", "banana"="바나나"}
	 * { "classDriverName"="com.jdbc.Oracle", "jdbcUrl" = "localhost", "username"="1234", "password"="1234"}
	 */
	public static void main(String[] args) {
		// Key : Long - value : Member
		Map<Long, Member> memberMap = new HashMap<>();
		memberMap.put(1L, new Member("홍길동"));
		memberMap.put(2L, new Member("김길동"));
		memberMap.put(3L, new Member("이길동"));
		memberMap.put(1L, new Member("박길동"));
		
		
		System.out.println(memberMap);
		System.out.println(memberMap.size()); // 맵의 크기 (요소의 개수)
		System.out.println(memberMap.isEmpty()); // empty 맵인지 여부
		System.out.println(memberMap.containsKey(2L)); // Key 존재 여부
		System.out.println(memberMap.containsValue(new Member("이길동"))); // value 존재 여부
		System.out.println(memberMap.containsValue("홍길동")); // value 존재 여부
		
		Member member = memberMap.get(1L);
		System.out.println(member);
		
		Collection<Member> values = memberMap.values();
		System.out.println(values);
		
		// Collection 타입의 객체를 List타입으로 삽입
		List<Member> memberList = new ArrayList<>();
		for(Member m : values) {
			memberList.add(m);
		}
		System.out.println(memberList);
	}
}

class Member {
	String name;
	
	public Member(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return name;
	}
	
	
}
