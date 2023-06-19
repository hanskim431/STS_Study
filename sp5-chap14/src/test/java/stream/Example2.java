package stream;

import java.util.ArrayList;
import java.util.List;
import java.util.OptionalDouble;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Example2 {

	public static void main(String[] args) {
		List<MemberVO> memberList = new ArrayList<MemberVO>();
		memberList.add(new MemberVO("kim", "kim@test.com", 10));
		memberList.add(new MemberVO("lee", "lee@test.com", 20));
		memberList.add(new MemberVO("park", "park@test.com", 30));
		memberList.add(new MemberVO("choi", "choi@test.com", 40));
		
		memberList.stream().filter(m->m.getScore()>=30)
			.forEach(m->System.out.println(m));
		System.out.println("===============");
		List<MemberVO> collect = memberList.stream()
				.filter(m->m.getScore()>=30)
				.collect(Collectors.toList());
		System.out.println(collect);
		System.out.println("===============");
		
		List<String> collect2 = memberList.stream()
			.filter(m->m.getScore()>=30)
		 	.map(m->m.getEmail()) // Stream<Integer> : 래퍼객체를 스트림으로 감싸고있음
			.collect(Collectors.toList());
		System.out.println(collect2);
		System.out.println("===============");
		
		int sum = memberList.stream()
			.mapToInt(m->m.getScore())
			.sum(); // IntStream : 기본타입을 스트림으로 감싸고 있음
		
		System.out.println(sum);
		
		System.out.println("===============");

		OptionalDouble optAvg= memberList.stream()
			.mapToInt(m->m.getScore())
			.average();
		
		System.out.println(optAvg);

		System.out.println("===============");
		
		optAvg.ifPresent(opt->System.out.println(opt));
		
		memberList.stream()
			.mapToInt(m->m.getScore())
			.average()
			.ifPresent(o->System.out.println(o));
		
		System.out.println("===============");

		double avg = memberList.stream()
			.mapToInt(m->m.getScore())
			.average().getAsDouble();
		
		System.out.println(avg);
	}
}
