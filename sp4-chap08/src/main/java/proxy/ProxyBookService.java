package proxy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Primary
@Component
public class ProxyBookService implements BookService { // 가짜 객체

	@Autowired
	BookServiceImpl bookServiceImpl;
	
	@Override
	public void createBook() {
		System.out.println("트랜잭션 시작 코드");
		bookServiceImpl.createBook(); // 진짜 객체의 createBook() 호출
		System.out.println("트랜잭션 마감 코드");
	}

	@Override
	public void pulishBook() {
		System.out.println("트랜잭션 시작 코드");
		bookServiceImpl.pulishBook(); // 진짜 객체의 pulishBook() 호출
		System.out.println("트랜잭션 마감 코드");

	}

}
