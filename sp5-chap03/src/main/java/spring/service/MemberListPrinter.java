package spring.service;

import java.util.List;

import spring.dao.MemberDao;
import spring.domain.Member;

public class MemberListPrinter {

	private MemberDao memberDao;
	private MemberPrinter memberPrinter;
	
	public MemberListPrinter(MemberDao memberDao, MemberPrinter memberPrinter) {
		this.memberDao = memberDao;
		this.memberPrinter = memberPrinter;
	}
	
	public void printAll() {
		List<Member> memberList = memberDao.selectAll();
//		for(Member m : memberList) {
//			memberPrinter.print(m);
//		}
		
		memberList.forEach(m -> memberPrinter.print(m));
	}
}
