package com.enit.MyExceptions;

public class PlusDePlaceException extends Exception{
	PlusDePlaceException(String str ){
		System.out.println(str);
	}

	public PlusDePlaceException() {
		super();
		// TODO Auto-generated constructor stub
	}
}
