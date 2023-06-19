package stream;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class Example {

	public static void main(String[] args) {
		
		List<Integer> intList = new ArrayList<Integer>();
		intList.add(1);
		intList.add(10);
		intList.add(12);
		intList.add(15);
		intList.add(16);
		
		Stream<Integer> stream = intList.stream(); 
		long count = intList.stream().count(); // count : 리턴값이 없는 최종연산
		System.out.println(count);
		System.out.println("=====");
		intList.stream().forEach(e->{
			System.out.println(e);
		});
		
		System.out.println("=====");
		intList.stream()
			.filter(e->e >= 12 ) // filter : stream 을 리턴하는 중간연산
			.forEach(e->System.out.println(e)); // forEach : 리턴값이 없는 최종연산
	}
}
