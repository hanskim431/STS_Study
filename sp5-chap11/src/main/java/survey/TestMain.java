package survey;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class TestMain {

	public static void main(String[] args) {
		List<String> list = null;
		System.out.println(list); // null
		
		list = Collections.emptyList(); 
		System.out.println(list); // []
		
		list = Collections.<String>emptyList(); 
		System.out.println(list); // []
		
		List<String> strList = Arrays.asList("가","나","다","라");
		System.out.println(strList);
//		list.add("마"); // UnsupportedOperationException
	}
}
