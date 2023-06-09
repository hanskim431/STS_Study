package sample;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.GenericXmlApplicationContext;

public class SampleMain {

	public static void main(String[] args) {
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext("classpath:sample/board-config.xml");
		BoardService boardService = ctx.getBean(BoardService.class);
		boardService.boardList();
		
	}
}
