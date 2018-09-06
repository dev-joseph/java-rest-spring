package com.rest.jersey.exeption;

public class DataNotFoundExeption extends RuntimeException {

	private static final long serialVersionUID = 454816695355541956L;

	public DataNotFoundExeption(String message) {
		super(message);
	}
}
