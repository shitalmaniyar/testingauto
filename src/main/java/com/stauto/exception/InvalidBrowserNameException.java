package com.stauto.exception;

public class InvalidBrowserNameException extends RuntimeException {
	public InvalidBrowserNameException(String browserName) {
	}

	@Override
	public String getMessage() {
		return super.getMessage();
	}
}
