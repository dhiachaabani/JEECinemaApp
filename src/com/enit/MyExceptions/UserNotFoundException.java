package com.enit.MyExceptions;

public class UserNotFoundException extends Exception {
	UserNotFoundException(String str ){
		System.out.println(str);
	}

	public UserNotFoundException() {
		super();
		// TODO Auto-generated constructor stub
	}
}
