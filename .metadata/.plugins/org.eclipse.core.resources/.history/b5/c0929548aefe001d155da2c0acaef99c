package sample2;

import org.springframework.stereotype.Component;

@Component
public class BoardService {

	private BoardDao boardDao;

//	@Autowired // 주입 대상의 빈이 하나일 경우(필드가 1개일 경우)에 Autowired 생략 가능
	public BoardService(BoardDao boardDao) {
		System.out.println("BoardService 생성자 실행");
		this.boardDao = boardDao;
	}

	public void boardList() {
		boardDao.list(); 
	}
}
