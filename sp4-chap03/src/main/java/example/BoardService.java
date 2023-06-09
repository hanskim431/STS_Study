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

// BoardService 가 BoardDao의 list() 메소드를 사용한다. -> BoardService가 BoardDao에 의존(Dependency)한다
// BoardService에 BoardDao타입의 필드가 정의되었다. -> BoardService가 BoardDao에 의존관계가 있다.
	// BoardDao : 의존 대상 객체
// BoardDao 필드에 객체를 생성하거나 외부로부터 받아야(Injection) 한다.
// 외부로부터 받는 방법 : 생성자 또는 수정자(setter) 메소드
	// 직접 생성 : BoardService가 BoardDao객체 생성 (강한 결합) => [부품 하나가 고장나면 수리하기 힘들어 모두 교체해야함]
	// 외부토부터 받기 : BoardService를 사용하는 곳 (BoardMain)에서 BoardDao를 생성하여 전달(Injection)(낮은 결합도 : 느슨한 결합)
		// 의존 주입 : BoardDao를 BoardService에 전달한다.

