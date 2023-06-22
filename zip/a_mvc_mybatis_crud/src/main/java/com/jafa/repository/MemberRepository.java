package com.jafa.repository;

import java.util.List;

import com.jafa.domain.MemberVO;

public interface MemberRepository {

	List<MemberVO> selectAll(); 

	MemberVO selectByEmail(String email); 
	
	void insert(MemberVO memberVO);
	
	void insertSelectKey(MemberVO memberVO);
	
	void update(MemberVO memberVO);
}
