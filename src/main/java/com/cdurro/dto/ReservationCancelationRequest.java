package com.cdurro.dto;

public class ReservationCancelationRequest {
	private Long userId;
	private Long movieId;
	private Long scheduleId;
	private Long seatId;
	private Long ticketId;

	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public Long getMovieId() {
		return movieId;
	}
	public void setMovieId(Long movieId) {
		this.movieId = movieId;
	}
	public Long getScheduleId() {
		return scheduleId;
	}
	public void setScheduleId(Long scheduleId) {
		this.scheduleId = scheduleId;
	}
	public Long getSeatId() {
		return seatId;
	}
	public void setSeatId(Long seatId) {
		this.seatId = seatId;
	}
	public Long getTicketId() {
		return ticketId;
	}
	public void setTicketId(Long ticketId) {
		this.ticketId = ticketId;
	}
	@Override
	public String toString() {
		return "ReservationCancelationRequest [userId=" + userId + ", movieId=" + movieId + ", scheduleId=" + scheduleId
				+ ", seatId=" + seatId + ", ticketId=" + ticketId + "]";
	}
}
