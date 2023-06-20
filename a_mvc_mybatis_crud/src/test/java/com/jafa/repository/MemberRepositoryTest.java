package com.jafa.repository;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.jafa.config.RootConfig;
import com.jafa.domain.MemberVO;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {RootConfig.class})
@Log4j
public class MemberRepositoryTest {

	@Autowired
	MemberRepository memberRepository;
	
	@Test
//	@Ignore
	public void test() {
		List<MemberVO> list = memberRepository.selectAll();
		log.info(list);
	}

	@Test
	@Ignore
	public void insertTest() {
		MemberVO vo = new MemberVO();
		vo.setEmail("park@test.com");
		vo.setName("박지성");
		vo.setPassword("5555");
		memberRepository.insert(vo);
	}
	
	@Test
	@Ignore
	public void insertSelectKeyTest() {
		MemberVO vo = new MemberVO();
		vo.setEmail("park@test.com");
		vo.setName("박지성");
		vo.setPassword("5555");
		memberRepository.insertSelectKey(vo);
		System.out.println(vo.getId());
	}
	
	@Test
	@Ignore
	public void updateTest() {
		MemberVO vo = new MemberVO();
		vo.setEmail("lee@test.com");
		vo.setName("이명박");
		vo.setPassword("1212");
		memberRepository.update(vo);
		System.out.println(vo.getName()+":"+vo.getPassword());
	}
	
	@Test
	@Ignore
	public void selectByEmailTest() {
		MemberVO vo = memberRepository.selectByEmail("lee@test.com");
		System.out.println(vo);
	}
}
