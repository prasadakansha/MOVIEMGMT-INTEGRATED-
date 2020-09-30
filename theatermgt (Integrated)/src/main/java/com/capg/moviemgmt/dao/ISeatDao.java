package com.capg.moviemgmt.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.capg.moviemgmt.entities.Seat;

@Repository
public interface ISeatDao extends JpaRepository<Seat, Integer>{

}
