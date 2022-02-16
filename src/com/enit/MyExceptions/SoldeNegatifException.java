package com.enit.MyExceptions;

public class SoldeNegatifException extends Exception{
	SoldeNegatifException(String str ){
		System.out.println(str);
	}

	public SoldeNegatifException() {
		super();
		// TODO Auto-generated constructor stub
	}
}
