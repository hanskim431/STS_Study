package spring.dao;

import java.util.List;

public interface MemberDao {

	// LIST
	List<Member> selectAll();
	
	// C
	void insert(Member member);
	
	// R
	Member selectByEmail(String email);
	
	// U
	void update(Member member);
	
	// D
	void delete(String email);
	
}
