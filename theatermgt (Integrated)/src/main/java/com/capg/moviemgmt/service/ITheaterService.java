package com.capg.moviemgmt.service;

import java.util.*;

import com.capg.moviemgmt.entities.Theater;

public interface ITheaterService {

	Theater save(Theater t);

	List<Theater> fetchAll();

	Theater fetchById(int theaterId);

	Boolean delete(int theaterId);

}
