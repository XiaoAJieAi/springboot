package com.n22.springboot.exception;

public class UserNotExistException extends RuntimeException {

	private static final long serialVersionUID = 5041291014052343735L;

	private String id;

	public UserNotExistException(String id) {
		super("user not exist");
		this.id = id;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
	
}
