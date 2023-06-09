package proxy;

import org.springframework.stereotype.Service;

@Service
public class BookServiceImpl implements BookService { // 진짜 객체

	@Override
	public void createBook() {
		System.out.println("BookServiceImpl.createBook()");
	}

	@Override
	public void pulishBook() {
		System.out.println("BookServiceImpl.pulishBook()");

	}

}
