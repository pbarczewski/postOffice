package com.pbarczewski.exceptions;

public class CustomizeException extends RuntimeException {
	public CustomizeException(String arg0, Throwable arg1) {
		super(arg0, arg1);
	}

	public CustomizeException(String arg0) {
		super(arg0);
	}

	public CustomizeException(Throwable arg0) {
		super(arg0);
	}
}
