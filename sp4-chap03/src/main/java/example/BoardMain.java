package example;

public class BoardMain {

	public static void main(String[] args) {
		// ������ ����
		BoardDao dao = new BoardDao();
		BoardService Service = new BoardService(dao);
		Service.memberList();
		
		// ������ �޼ҵ�� ����
		BoardDao boardDao = new BoardDao(); // ���� : ���͸� 
		BoardService boardService = new BoardService(); // ���� : �޴���
		boardService.setBoardDao(boardDao); // ����
		boardService.memberList();
	}
}
