package com.capg.moviemgmt.service;

import java.util.List;

import com.capg.moviemgmt.entities.Screen;

public interface IScreenService {

	Screen addScreen(Screen screen);

	Boolean deleteScreen(int screenId);

	Screen viewScreen(int screenId);

	List<Screen> viewAllScreens();
}
