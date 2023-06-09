package com.jafa.domain;

import lombok.ToString;

@ToString
public class DemoVO {

	private Long id;
	private String name;
	private String address;
	
	public DemoVO setId(Long id) {
		this.id = id;
		return this;
	}
	
	public DemoVO setName(String name) {
		this.name = name;
		return this;
	}

	public DemoVO setAddress(String address) {
		this.address = address;
		return this;
	}
	
	public static void main(String[] args) {
		DemoVO demoVO = new DemoVO();
		demoVO.setName("홍길동");
		demoVO.setAddress("대구광역시");

		demoVO.setId(1L).setName("홍길동").setAddress("대구광역시");
		demoVO.setName("김경환").setId(2L).setAddress("대구광역시");
		demoVO.setAddress("대구광역시").setName("홍석천").setId(3L);
		
		System.out.println(demoVO);
	}
}
