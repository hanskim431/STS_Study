package spring.service;

import spring.dao.MemberDao;
import spring.domain.Member;

public class MemberInfoPrinter {

	private MemberDao memberDao;
	private MemberPrinter memberPrinter;
	
	public void setMemberDao(MemberDao memberDao) {
		this.memberDao = memberDao;
	}
	
	public void setMemberPrinter(MemberPrinter memberPrinter) {
		this.memberPrinter = memberPrinter;
	}

	public void printMemberInfo(String email) {
		Member member = memberDao.selectByEmail(email);
		if(member == null) { 
			System.out.println("No Data");
			return;
		}
		memberPrinter.print(member);
		System.out.println();
		
		
	}
}
