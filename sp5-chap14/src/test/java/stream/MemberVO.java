package stream;

public class MemberVO {
	private String name;
	private String email;
	private int score;
	
	@Override
	public String toString() {
		return "MemberVO [name=" + name + ", email=" + email + ", score=" + score + "]";
	}
	
	public MemberVO(String name, String email, int score) {
		this.name = name;
		this.email = email;
		this.score = score;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	
	
}
