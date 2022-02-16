package com.enit.MyExceptions;

public class SoldeInsuffisantException extends Exception{
	SoldeInsuffisantException(String str ){
		System.out.println(str);
	}

	public SoldeInsuffisantException() {
		super();
		// TODO Auto-generated constructor stub
	}
}
