package com.capg.moviemgmt.controller;

import java.util.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capg.moviemgmt.dto.CreateTheaterRequest;
import com.capg.moviemgmt.dto.TheaterDetailsDto;
import com.capg.moviemgmt.entities.Movie;
import com.capg.moviemgmt.entities.Theater;
import com.capg.moviemgmt.exception.TheaterNotFoundException;
import com.capg.moviemgmt.service.ITheaterService;

/***
 * @author Akansha Prasad
 */
/****
 * Spring RestController annotation is used to create RESTful web services.
 */
@RestController
@RequestMapping("/theaters")
public class TheaterController {

	private static final Logger Log = LoggerFactory.getLogger(TheaterController.class);

	@Autowired
	private ITheaterService service;

	/****
	 * Adding theater
	 * 
	 * @param thaeterDto
	 * @return
	 **/
	@PostMapping("/add")
	public ResponseEntity<TheaterDetailsDto> addTheater(@RequestBody CreateTheaterRequest theaterDto) {
		Theater theater = convert(theaterDto);
		theater = service.save(theater);
		TheaterDetailsDto detailsDto = convertTheaterDetails(theater);
		ResponseEntity<TheaterDetailsDto> response = new ResponseEntity<TheaterDetailsDto>(detailsDto, HttpStatus.OK);
		return response;
	}

	/****
	 * Fetching all theaters
	 * 
	 * @return
	 */
	@GetMapping
	public ResponseEntity<List<Theater>> fetchAll() {
		List<Theater> theaters = service.fetchAll();
		ResponseEntity<List<Theater>> response = new ResponseEntity<>(theaters, HttpStatus.OK);
		return response;
	}

	/**
	 * Fetching theater by theater id
	 * 
	 * @param theaterId
	 * @return
	 */
	@GetMapping("/get/{id}")
	public ResponseEntity<TheaterDetailsDto> fetchById(@PathVariable("id") int theaterId) {
		Theater theater = service.fetchById(theaterId);
		TheaterDetailsDto detailsDto = convertTheaterDetails(theater);
		ResponseEntity<TheaterDetailsDto> response = new ResponseEntity<TheaterDetailsDto>(detailsDto, HttpStatus.OK);
		return response;
	}

	/**
	 * Deleting theater by theater id
	 * 
	 * @param theaterId
	 * @return
	 */
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Boolean> deleteTheater(@PathVariable("id") int theaterId) {
		Boolean result = service.delete(theaterId);
		ResponseEntity<Boolean> response = new ResponseEntity<Boolean>(result, HttpStatus.OK);
		return response;
	}

	/**
	 * convert from theater: dto -> entity
	 * 
	 * @param theaterDto
	 * @return
	 */
	public Theater convert(CreateTheaterRequest theaterdto) {
		Theater theater = new Theater();
		theater.setTheaterId(theaterdto.getTheaterId());
		theater.setTheaterName(theaterdto.getTheaterName());
		theater.setTheaterCity(theaterdto.getTheaterCity());
		theater.setScreenList(theaterdto.getScreenList());
		theater.setMovieList(theaterdto.getMovieList());
		theater.setManagerName(theaterdto.getManagerName());
		theater.setManagerContact(theaterdto.getManagerContact());
		return theater;
	}

	/**
	 * convert from theater: entity -> detailsdto
	 * 
	 * @param app
	 * @return
	 */
	public TheaterDetailsDto convertTheaterDetails(Theater theater) {
		TheaterDetailsDto detailsDto = new TheaterDetailsDto();
		detailsDto.setTheaterId(theater.getTheaterId());
		detailsDto.setTheaterName(theater.getTheaterName());
		detailsDto.setTheaterCity(theater.getTheaterCity());
		detailsDto.setScreenList(theater.getScreenList());
		detailsDto.setMovieList(theater.getMovieList());
		detailsDto.setManagerName(theater.getManagerName());
		detailsDto.setManagerContact(theater.getManagerContact());
		return detailsDto;
	}

	@ExceptionHandler(TheaterNotFoundException.class)
	public ResponseEntity<String> handleCustomerNotFound(TheaterNotFoundException ex) {
		Log.error("handleTheaterNotFound()", ex);
		String msg = ex.getMessage();
		ResponseEntity<String> response = new ResponseEntity<>(msg, HttpStatus.NOT_FOUND);
		return response;
	}

	@ExceptionHandler(Throwable.class)
	public ResponseEntity<String> handleAll(Throwable ex) {
		Log.error("handleAll()", ex);// this will get logged
		String msg = ex.getMessage();
		ResponseEntity<String> response = new ResponseEntity<>(msg, HttpStatus.INTERNAL_SERVER_ERROR);
		return response;
	}

}
