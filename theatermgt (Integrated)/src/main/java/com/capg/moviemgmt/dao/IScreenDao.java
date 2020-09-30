package com.capg.moviemgmt.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.capg.moviemgmt.entities.Screen;

@Repository
public interface IScreenDao extends JpaRepository<Screen, Integer> {
}
