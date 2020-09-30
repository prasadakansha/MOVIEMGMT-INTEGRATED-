package com.capg.moviemgmt.dto;

import com.capg.moviemgmt.entities.BookingState;

public class RequestSeatDto {

	private BookingState seatStatus;
	private double seatPrice;

	public BookingState getSeatStatus() {
		return seatStatus;
	}

	public void setSeatStatus(BookingState seatStatus) {
		this.seatStatus = seatStatus;
	}

	public double getSeatPrice() {
		return seatPrice;
	}

	public void setSeatPrice(double seatPrice) {
		this.seatPrice = seatPrice;
	}

}
