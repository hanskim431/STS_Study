package spring.service;

import org.springframework.beans.factory.annotation.Autowired;

import spring.dao.MemberDao;
import spring.domain.Member;

public class MemberInfoPrinter {

	private MemberDao memberDao;
	private MemberPrinter memberPrinter;
	
	@Autowired
	public void setMemberDao(MemberDao memberDao) {
		this.memberDao = memberDao;
	}
	
	@Autowired
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
