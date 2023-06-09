package sample2;

import org.springframework.stereotype.Component;

@Component
public class BoardService {

	private BoardDao boardDao;

//	@Autowired // ���� ����� ���� �ϳ��� ���(�ʵ尡 1���� ���)�� Autowired ���� ����
	public BoardService(BoardDao boardDao) {
		System.out.println("BoardService ������ ����");
		this.boardDao = boardDao;
	}

	public void boardList() {
		boardDao.list(); 
	}
}
