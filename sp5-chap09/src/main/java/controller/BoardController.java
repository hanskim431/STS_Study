package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import domain.BoardVO;

@Controller
@RequestMapping("/board")
public class BoardController {

	@GetMapping({"/list", "/boardList"})
	public String list() {
		return "board/list";
	}
	
	@GetMapping("/get")
	public void getBoard(Long bno) {
		System.out.println("게시물 번호 : " + bno);
	}
	
	@GetMapping("/write")
	public void writeForm(@ModelAttribute("boardVO") BoardVO vo) {
	}
	
	@PostMapping("/boardWrite")
	public String write(BoardVO vo) {
		System.out.println(vo);
		return "redirect:";
		
	}
}
