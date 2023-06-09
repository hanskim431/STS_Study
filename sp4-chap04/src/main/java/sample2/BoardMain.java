package sample2;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class BoardMain {

	public static void main(String[] args) {
		ApplicationContext ctx = new GenericXmlApplicationContext("classpath:sample2/board-config.xml");
		BoardService bean = ctx.getBean(BoardService.class);
		bean.boardList();
	}
}
