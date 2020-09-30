package com.capg.moviemgmt.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capg.moviemgmt.dto.RequestSeatDto;
import com.capg.moviemgmt.entities.Seat;
import com.capg.moviemgmt.exception.SeatNotFoundException;
import com.capg.moviemgmt.service.ISeatService;

@RestController
@RequestMapping("/seats")
public class SeatController {

	@Autowired
	private ISeatService seatService;

	/* add new seat */
	@PostMapping("/add")
	public ResponseEntity<Seat> addSeat(@RequestBody RequestSeatDto seatDto) {
		Seat seat = convertFromDtoToSeat(seatDto);
		seat = seatService.saveSeat(seat);
		ResponseEntity<Seat> reponse = new ResponseEntity<Seat>(seat, HttpStatus.OK);
		return reponse;
	}

	/* convert dto details into seat */
	public Seat convertFromDtoToSeat(RequestSeatDto requestData) {
		Seat seat = new Seat();
		seat.setSeatPrice(requestData.getSeatPrice());
		seat.setSeatStatus(requestData.getSeatStatus());
		return seat;
	}

	/* get all seat details */
	@GetMapping("/getall")
	public ResponseEntity<List<Seat>> fetchAllSeats() {
		List<Seat> list = seatService.getAllSeats();
		ResponseEntity<List<Seat>> reponse = new ResponseEntity<List<Seat>>(list, HttpStatus.OK);
		return reponse;
	}

	/* block seat using seatid */
	@GetMapping("/blockseat/{id}")
	public ResponseEntity<Boolean> blockSeat(@PathVariable("id") int seatId) {
		Boolean result = seatService.blockSeats(seatId);
		ResponseEntity<Boolean> reponse = new ResponseEntity<Boolean>(result, HttpStatus.OK);
		return reponse;
	}

	/* book seat using seatid */
	@GetMapping("/bookseat/{id}")
	public ResponseEntity<Boolean> bookSeat(@PathVariable("id") int seatId) {
		Boolean result = seatService.bookSeats(seatId);
		ResponseEntity<Boolean> reponse = new ResponseEntity<Boolean>(result, HttpStatus.OK);
		return reponse;
	}

	/* cancel seat using seatid */
	@GetMapping("/cancelseat/{id}")
	public ResponseEntity<Boolean> cancelSeat(@PathVariable("id") int seatId) {
		Boolean result = seatService.cancelSeatBooking(seatId);
		ResponseEntity<Boolean> reponse = new ResponseEntity<Boolean>(result, HttpStatus.OK);
		return reponse;
	}

	@ExceptionHandler(SeatNotFoundException.class)
	public ResponseEntity<String> handleSeatNotFound(SeatNotFoundException exception) {
		String message = exception.getMessage();
		ResponseEntity<String> response = new ResponseEntity<>(message, HttpStatus.NOT_FOUND);
		return response;
	}

}
