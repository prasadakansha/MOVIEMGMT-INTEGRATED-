package com.capg.moviemgmt.service;

import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capg.moviemgmt.dao.ISeatDao;
import com.capg.moviemgmt.entities.BookingState;
import com.capg.moviemgmt.entities.Seat;
import com.capg.moviemgmt.exception.SeatNotFoundException;

@Service
@Transactional
public class SeatServiceImpl implements ISeatService {

	private ISeatDao seatDao;

	public ISeatDao getSeatDao() {
		return seatDao;
	}

	@Autowired
	public void setSeatDao(ISeatDao seatDao) {
		this.seatDao = seatDao;
	}

	/***add new seat***/
	@Override
	public Seat saveSeat(Seat seat) {
		seat = seatDao.save(seat);
		return seat;
	}

	/*get all seat details*/
	@Override
	public List<Seat> getAllSeats() {
		List<Seat> list = seatDao.findAll();
		return list;
	}

	/*block seat using seatId*/
	@Override
	public Boolean blockSeats(int seatId) {
		Seat seat = getSeat(seatId);
		if (seat != null) {
			seat.setSeatStatus(BookingState.Blocked);
			seatDao.save(seat);
			return true;
		}
		return false;
	}

	/*book seat using seatId*/
	@Override
	public Boolean bookSeats(int seatId) {
		Seat seat = getSeat(seatId);
		if (seat != null) {
			seat.setSeatStatus(BookingState.Booked);
			seatDao.save(seat);
			return true;
		}
		return false;
	}

	/*cancel seat using seatId*/
	@Override
	public Boolean cancelSeatBooking(int seatId) {
		Seat seat = getSeat(seatId);
		if (seat != null) {
			seat.setSeatStatus(BookingState.Available);
			seatDao.save(seat);
			return true;
		}
		return false;
	}

	/*get seatdetails using seatId*/
	public Seat getSeat(int seatId) {
		Optional<Seat> optional = seatDao.findById(seatId);
		if (optional.isPresent()) {
			return optional.get();
		}
		throw new SeatNotFoundException("Seat not found for id=" + seatId);
	}

}
