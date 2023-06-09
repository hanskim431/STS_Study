package spring.dao;

import java.util.List;

public interface MemberDao {

	Member selectByEmail(String email);
	
	List<Member> selectAll();
	
	void insert(Member member);

	void update(Member member);
	
	default void delete(String email) {
		System.out.println("지원하지 않는 기능입니다.");
	};
}
