package com.vegetable.exception;

public class NoOrderDateFoundException extends Exception {

	public NoOrderDateFoundException(String date) {
		super(date);
	}
}
