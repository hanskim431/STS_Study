package controller;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import spring.Member;
import spring.MemberDao;

@Controller
public class MemberListController {
	
	private MemberDao memberDao;

	public void setMemberDao(MemberDao memberDao) {
		this.memberDao = memberDao;
	}
	
	// 요청 : /members?from=2023061000&2023061000
	@RequestMapping("/members")
	public String list(@ModelAttribute("cmd") ListCommand listCommand, Errors errors, Model model) {

		if(errors.hasErrors()) {
			System.out.println("================");
			
			List<String[]> list = errors.getAllErrors().
			stream().map(e->e.getCodes()).collect(Collectors.toList());
			list.forEach(e->System.out.println(Arrays.toString(e)));
			
			System.out.println("================");
			
			return "member/memberList";
		}
		
		System.out.println(listCommand);
		if(listCommand.getFrom()!=null && listCommand.getTo()!=null) { // NullPointError 방지 :LocalDateTime from 과 LocalDateTime to 가 둘다 있을 경우 
			List<Member> members = memberDao.selectByRegdate(listCommand.getFrom(), listCommand.getTo()); // memberDao.selectByRegdate 실행
			model.addAttribute("members", members); // jsp 페이지에서 사용할 members 모델 속성 추가
		}
		
		return "member/memberList";
	}
	
	
}
