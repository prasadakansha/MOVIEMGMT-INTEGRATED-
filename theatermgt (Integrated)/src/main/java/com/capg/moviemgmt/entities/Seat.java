package com.capg.moviemgmt.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "seatdetails")
public class Seat {

	@Id
	@GeneratedValue
	@Column(name = "seatId")
	private int seatId;
	@Enumerated(EnumType.STRING)
	private BookingState seatStatus;
	@Column(name = "seatPrice")
	private double seatPrice;

	public int getSeatId() {
		return seatId;
	}

	public void setSeatId(int seatId) {
		this.seatId = seatId;
	}

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

	@Override
	public String toString() {
		return "Seat [seatId=" + seatId + ", seatStatus=" + seatStatus + ", seatPrice=" + seatPrice + "]";
	}

}
