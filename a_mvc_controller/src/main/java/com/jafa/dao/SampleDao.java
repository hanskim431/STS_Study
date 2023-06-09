package com.jafa.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.jafa.domain.SampleVO;

//@Component
@Repository // 데이터를 다루는 Dao라 @Component 대신 구체적인 @Repository 이노테이션을 사용함. 기능적 차이는 없음. 식별용
public class SampleDao {
	
	public List<SampleVO> list() {
		List<SampleVO> list = new ArrayList<SampleVO>();
		list.add(SampleVO.builder().id(1L).title("샘플1").content("내용1").build());
		list.add(SampleVO.builder().id(1L).title("샘플2").content("내용2").build());
		list.add(SampleVO.builder().id(1L).title("샘플3").content("내용3").build());
		list.add(SampleVO.builder().id(1L).title("샘플4").content("내용4").build());
		return list;
	}
}
