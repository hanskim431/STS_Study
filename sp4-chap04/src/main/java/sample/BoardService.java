package sample;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class BoardService {

	// 필드 자동 주입
//	@Autowired
	private BoardDao boardDao;

	// 수정자 자동 주입 : 일반적으로 권장
	@Autowired
	@Qualifier("boardDao1")
	public void setBoardDao(BoardDao boardDao) {
		System.out.println("setBoardDao() 실행");
		this.boardDao = boardDao;
	}
	
	public BoardService() {}
	
	// 생성자 자동 주입
//	@Autowired
//	public BoardService(@Qualifier("boardDao2") BoardDao boardDao) {
	public BoardService(BoardDao boardDao) {
		System.out.println("BoardService 생성자 실행");
		this.boardDao = boardDao;
	}

	public void boardList() {
		boardDao.list(); 
	}
}
