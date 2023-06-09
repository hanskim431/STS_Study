package proxy;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ProxyMain {

	public static void main(String[] args) {
		
		ApplicationContext ctx = new AnnotationConfigApplicationContext(RootConfig.class);
		
		BookService bookService = ctx.getBean(BookService.class);
		bookService.createBook();
		bookService.pulishBook();
	}
}
