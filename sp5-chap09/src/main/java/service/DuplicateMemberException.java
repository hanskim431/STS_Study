package service;

public class DuplicateMemberException extends RuntimeException {

	public DuplicateMemberException(String message) {
		super(message); // e.getMessage(); 로 받을 수 있음.
	}

}
