package com.capg.moviemgmt.exception;

public class SeatNotFoundException extends RuntimeException {
	
	public SeatNotFoundException(String message) {
		super(message);
	}
}
