package com.cdurro.dto;

import com.cdurro.model.Movie;
import com.cdurro.model.Schedule;
import com.cdurro.model.Seat;

public class ReservedMovieResponse {
	private Long ticketId;
	private Movie movie;
	private Schedule schedule;
	private Seat seat;

	public ReservedMovieResponse(Long id, Movie movie, Schedule schedule, Seat seat) {
		this.ticketId = id;
		this.movie = movie;
		this.schedule = schedule;
		this.seat = seat;
	}
	public Long getTicketId() {
		return ticketId;
	}
	public void setTicketId(Long ticketId) {
		this.ticketId = ticketId;
	}
	public Movie getMovie() {
		return movie;
	}
	public void setMovie(Movie movie) {
		this.movie = movie;
	}
	public Schedule getSchedule() {
		return schedule;
	}
	public void setSchedule(Schedule schedule) {
		this.schedule = schedule;
	}
	public Seat getSeat() {
		return seat;
	}
	public void setSeat(Seat seat) {
		this.seat = seat;
	}
	@Override
	public String toString() {
		return "ReservedMoviesResponse [ticketId=" + ticketId + ", movie=" + movie + ", schedule=" + schedule
				+ ", seat=" + seat + "]";
	}
}
