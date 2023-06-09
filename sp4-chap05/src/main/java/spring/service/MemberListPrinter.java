package spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import spring.dao.MemberDao;
import spring.domain.Member;

@Component
public class MemberListPrinter {

	private MemberDao memberDao;
	private MemberPrinter memberPrinter;
	
	@Autowired
	public MemberListPrinter(MemberDao memberDao, MemberPrinter memberPrinter) {
		this.memberDao = memberDao;
		this.memberPrinter = memberPrinter;
	}
	
	public MemberListPrinter() {}

	public void printAll() {
		List<Member> memberList = memberDao.selectAll();
//		for(Member m : memberList) {
//			memberPrinter.print(m);
//		}
		
		memberList.forEach(m -> memberPrinter.print(m));
	}
}
