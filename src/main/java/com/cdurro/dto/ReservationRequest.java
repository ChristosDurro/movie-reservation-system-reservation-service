package com.cdurro.dto;

import java.util.List;

import com.cdurro.model.Ticket;

public class ReservationRequest {
	
	private UserDTO user;
	private List<Ticket> ticketsList;
	private SeatAvailabilityDTO seats;
	
	public UserDTO getUser() {
		return user;
	}
	public void setUser(UserDTO user) {
		this.user = user;
	}
	public List<Ticket> getTicketsList() {
		return ticketsList;
	}
	public void setTicketsList(List<Ticket> ticketsList) {
		this.ticketsList = ticketsList;
	}
	public SeatAvailabilityDTO getSeats() {
		return seats;
	}
	public void setSeats(SeatAvailabilityDTO seats) {
		this.seats = seats;
	}
	@Override
	public String toString() {
		return "ReservationRequest [user=" + user + ", ticketsList=" + ticketsList + ", seats=" + seats + "]";
	}
}
