package com.capg.moviemgmt.service;

import java.util.List;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capg.moviemgmt.dao.Dao;
import com.capg.moviemgmt.entities.Theater;
import com.capg.moviemgmt.exception.TheaterNotFoundException;

/***
 * @author Akansha Prasad
 */
/***
 * A service layer is an additional layer in an application that mediates
 * communication between a controller and dao layer. The service layer contains
 * business logic. In particular, it contains validation logic.
 */
@Service
@Transactional
public class TheaterServiceImpl implements ITheaterService {

	@Autowired
	private Dao dao;

	@Override
	public Theater save(Theater t) {
		Theater theater = dao.save(t);
		return theater;
	}

	@Override
	public List<Theater> fetchAll() {
		List<Theater> theaters = dao.findAll();
		return theaters;
	}

	@Override
	public Theater fetchById(int theaterId) {
		Optional<Theater> optional = dao.findById(theaterId);
		if (optional.isPresent()) {
			Theater th = optional.get();
			return th;
		}
		throw new TheaterNotFoundException("theater not found for id=" + theaterId);
	}

	@Override
	public Boolean delete(int theaterId) {
		Theater theater = fetchById(theaterId);
		dao.delete(theater);
		return true;
	}

}
