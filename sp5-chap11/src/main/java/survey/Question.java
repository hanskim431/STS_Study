package survey;

import java.util.Collections;
import java.util.List;

public class Question {

	private String title;
	private List<String> options;
	
	// 객관식 문항
	public Question(String title, List<String> options) {
		this.title = title;
		this.options = options;
	}
	
	// 주관식 문항
	public Question(String title) {
		this(title,Collections.<String>emptyList());
	}
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public List<String> getOptions() {
		return options;
	}
	public void setOptions(List<String> options) {
		this.options = options;
	}

	public boolean isChoice() { // 객관식 여부
		return options != null && !options.isEmpty();
		
	}
}
