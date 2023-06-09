package example;

public class BoardMain {

	public static void main(String[] args) {
		// 생성자 전달
		BoardDao dao = new BoardDao();
		BoardService Service = new BoardService(dao);
		Service.memberList();
		
		// 수정자 메소드로 전달
		BoardDao boardDao = new BoardDao(); // 예시 : 배터리 
		BoardService boardService = new BoardService(); // 예시 : 휴대폰
		boardService.setBoardDao(boardDao); // 결합
		boardService.memberList();
	}
}
