package demo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//  Map ����
public class Example01 {
	
	/* 
	 * Map 
	 * key - value �� ������ �̷����
	 * {"apple"="���", "kiwi"="Ű��", "banana"="�ٳ���"}
	 * { "classDriverName"="com.jdbc.Oracle", "jdbcUrl" = "localhost", "username"="1234", "password"="1234"}
	 */
	public static void main(String[] args) {
		// Key : Long - value : Member
		Map<Long, Member> memberMap = new HashMap<>();
		memberMap.put(1L, new Member("ȫ�浿"));
		memberMap.put(2L, new Member("��浿"));
		memberMap.put(3L, new Member("�̱浿"));
		memberMap.put(1L, new Member("�ڱ浿"));
		
		
		System.out.println(memberMap);
		System.out.println(memberMap.size()); // ���� ũ�� (����� ����)
		System.out.println(memberMap.isEmpty()); // empty ������ ����
		System.out.println(memberMap.containsKey(2L)); // Key ���� ����
		System.out.println(memberMap.containsValue(new Member("�̱浿"))); // value ���� ����
		System.out.println(memberMap.containsValue("ȫ�浿")); // value ���� ����
		
		Member member = memberMap.get(1L);
		System.out.println(member);
		
		Collection<Member> values = memberMap.values();
		System.out.println(values);
		
		// Collection Ÿ���� ��ü�� ListŸ������ ����
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
