package com.capg.moviemgmt.controller;

import java.util.List;

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

import com.capg.moviemgmt.dto.RequestScreenDto;
import com.capg.moviemgmt.entities.Screen;
import com.capg.moviemgmt.exception.ScreenNotFoundException;
import com.capg.moviemgmt.service.IScreenService;

@RestController
@RequestMapping("/screens")
public class ScreenController {

	@Autowired
	private IScreenService screenService;

	/**add new screen***/
	@PostMapping("/add")
	public ResponseEntity<Screen> addScreen(@RequestBody RequestScreenDto screenDto) {
		Screen screen = convertFromDtoToScreen(screenDto);
		screen = screenService.addScreen(screen);
		ResponseEntity<Screen> reponse = new ResponseEntity<Screen>(screen, HttpStatus.OK);
		return reponse;
	}

	/*delete screen*/
	@DeleteMapping("/deletebyid/{id}")
	public ResponseEntity<Boolean> deleteScreen(@PathVariable("id") int screenId) {
		Boolean result = screenService.deleteScreen(screenId);
		ResponseEntity<Boolean> reponse = new ResponseEntity<Boolean>(result, HttpStatus.OK);
		return reponse;
	}

	/*convert dto details into screen*/
	public Screen convertFromDtoToScreen(RequestScreenDto requestData) {
		Screen screen = new Screen();
		screen.setTheaterId(requestData.getTheaterId());
		screen.setScreenName(requestData.getScreenName());
		screen.setRows(requestData.getRows());
		screen.setColumns(requestData.getColumns());
		screen.setShowList(requestData.getShowList());
		return screen;
	}

	/*get screen details using screenid*/
	@GetMapping("/getbyid/{id}")
	public ResponseEntity<Screen> fetchScreenById(@PathVariable("id") int screenId) {
		Screen screen = screenService.viewScreen(screenId);
		ResponseEntity<Screen> reponse = new ResponseEntity<Screen>(screen, HttpStatus.OK);
		return reponse;
	}

	/*get all screen details*/
	@GetMapping("/getall")
	public ResponseEntity<List<Screen>> fetchAllScreens() {
		List<Screen> list = screenService.viewAllScreens();
		ResponseEntity<List<Screen>> reponse = new ResponseEntity<List<Screen>>(list, HttpStatus.OK);
		return reponse;
	}

	@ExceptionHandler(ScreenNotFoundException.class)
	public ResponseEntity<String> handleScreenNotFound(ScreenNotFoundException exception) {
		String message = exception.getMessage();
		ResponseEntity<String> response = new ResponseEntity<>(message, HttpStatus.NOT_FOUND);
		return response;
	}
}

