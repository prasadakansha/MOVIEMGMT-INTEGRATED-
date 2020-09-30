package com.capg.moviemgmt.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.capg.moviemgmt.entities.Theater;

/***
 * @author Akansha Prasad
 */
/***
 * DAO design pattern is a way to reduce coupling between Business logic and
 * Persistence logic.
 */
@Repository
public interface Dao extends JpaRepository<Theater, Integer> {

}
