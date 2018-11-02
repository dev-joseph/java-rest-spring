package com.rest.jersey.exeption;

public class AuthenticationFailException extends RuntimeException {
	private static final long serialVersionUID = 454816695355541956L;

	public AuthenticationFailException(String message) {
		super(message);
	}
}
