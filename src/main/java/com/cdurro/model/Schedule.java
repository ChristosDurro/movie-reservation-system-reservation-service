package com.cdurro.model;

import java.time.LocalDateTime;

public class Schedule {
	private Long id;
	private String hall;
	private LocalDateTime showtime;
	private int movieId;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getHall() {
		return hall;
	}
	public void setHall(String hall) {
		this.hall = hall;
	}
	public LocalDateTime getShowtime() {
		return showtime;
	}
	public void setShowtime(LocalDateTime showtime) {
		this.showtime = showtime;
	}
	public int getMovieId() {
		return movieId;
	}
	public void setMovieId(int movieId) {
		this.movieId = movieId;
	}
	@Override
	public String toString() {
		return "Schedule [id=" + id + ", hall=" + hall + ", showtime=" + showtime + ", movieId=" + movieId + "]";
	}
}
