package form;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import spring.RegisterRequest;

@Controller
@RequestMapping("/form")
public class FormController {
	
	@GetMapping("/form1")
	public String form1(RegisterRequest registerRequest) {
//		registerRequest.setName("김길동");
		return "form/form1";
	}
	
	@GetMapping("/form2")
	public String form2(FormCommand formCommand, Model model) {
		// 회원 유형
		List<String> loginType = new ArrayList<String>();
		loginType.add("일반회원");
		loginType.add("기업회원");
		loginType.add("헤드헌터회원");
		model.addAttribute("loginType", loginType); // ${loginType}
		
		// 선호 OS : 문자열 배열
		model.addAttribute("favoriteOsNames", new String[] {"win", "Linux", "mac"});
		
		// 직종코드
		List<Code> jobCodes = Arrays.asList(
				new Code("01", "프로그래머"),
				new Code("02", "디자이너"),
				new Code("03", "기획자"));
		model.addAttribute("jobCode", jobCodes);

		// 선호 OS : code 객체 사용
		List<Code> favoriteOsCodes = Arrays.asList(
				new Code("01", "win"),
				new Code("02", "Linux"),
				new Code("03", "mac"));
		model.addAttribute("favoriteOsCodes", favoriteOsCodes);
		return "form/form2";
	}
	
	@PostMapping("/form2")
	public String submit(FormCommand formCommand, Model model) {
		System.out.println(formCommand);
		return "form/other";
	}
}
