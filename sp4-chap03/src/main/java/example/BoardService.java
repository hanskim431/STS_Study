package example;

public class BoardService {
	private BoardDao boardDao;
	
	public BoardService(BoardDao boardDao) {
		this.boardDao = boardDao;
	}

	public BoardService() {
		
	}

	public void setBoardDao(BoardDao boardDao) {
		this.boardDao = boardDao;
	}

	public void memberList() {
		boardDao.list();
	}
}

// BoardService �� BoardDao�� list() �޼ҵ带 ����Ѵ�. -> BoardService�� BoardDao�� ����(Dependency)�Ѵ�
// BoardService�� BoardDaoŸ���� �ʵ尡 ���ǵǾ���. -> BoardService�� BoardDao�� �������谡 �ִ�.
	// BoardDao : ���� ��� ��ü
// BoardDao �ʵ忡 ��ü�� �����ϰų� �ܺηκ��� �޾ƾ�(Injection) �Ѵ�.
// �ܺηκ��� �޴� ��� : ������ �Ǵ� ������(setter) �޼ҵ�
	// ���� ���� : BoardService�� BoardDao��ü ���� (���� ����) => [��ǰ �ϳ��� ���峪�� �����ϱ� ����� ��� ��ü�ؾ���]
	// �ܺ������ �ޱ� : BoardService�� ����ϴ� �� (BoardMain)���� BoardDao�� �����Ͽ� ����(Injection)(���� ���յ� : ������ ����)
		// ���� ���� : BoardDao�� BoardService�� �����Ѵ�.

