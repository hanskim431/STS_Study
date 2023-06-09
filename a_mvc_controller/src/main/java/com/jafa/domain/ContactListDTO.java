package com.jafa.domain;

import java.util.List;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ContactListDTO { // 커맨드 객체
	List<ContactVO> contactList; // 중첩 객체
}
