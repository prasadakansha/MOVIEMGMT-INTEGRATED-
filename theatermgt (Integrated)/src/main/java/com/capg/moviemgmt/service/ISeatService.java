package com.capg.moviemgmt.service;

import java.util.List;

import com.capg.moviemgmt.entities.Seat;

public interface ISeatService {

	Seat saveSeat(Seat seat);

	List<Seat> getAllSeats();

	Boolean blockSeats(int seatId);

	Boolean bookSeats(int seatId);

	Boolean cancelSeatBooking(int seatId);
}
