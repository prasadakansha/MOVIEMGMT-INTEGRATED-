package com.capg.moviemgmt.exception;

public class TheaterNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 2564463389454678565L;

	public TheaterNotFoundException(String msg) {
		super(msg);
	}
}
