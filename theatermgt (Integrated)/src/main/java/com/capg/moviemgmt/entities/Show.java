package com.capg.moviemgmt.entities;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Show {
	@Id
	@GeneratedValue
	@Column(name = "show_id")
	private int showId;
	private LocalDateTime showStartTime;
	private LocalDateTime showEndTime;
	@OneToMany(cascade = CascadeType.ALL)
	private List<Seat> seatsId;
	private String showName;
	private String movieName;

	public int getShowId() {
		return showId;
	}

	public void setShowId(int showId) {
		this.showId = showId;
	}

	public LocalDateTime getShowStartTime() {
		return showStartTime;
	}

	public void setShowStartTime(LocalDateTime showStartTime) {
		this.showStartTime = showStartTime;
	}

	public LocalDateTime getShowEndTime() {
		return showEndTime;
	}

	public void setShowEndTime(LocalDateTime showEndTime) {
		this.showEndTime = showEndTime;
	}

	public String getShowName() {
		return showName;
	}

	public void setShowName(String showName) {
		this.showName = showName;
	}

	public List<Seat> getSeatsId() {
		return seatsId;
	}

	public void setSeatsId(List<Seat> seatsId) {
		this.seatsId = seatsId;
	}

	public String getMovieName() {
		return movieName;
	}

	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}

}
