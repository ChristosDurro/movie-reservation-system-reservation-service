package com.cdurro.dto;

import java.util.List;

public class ReservationCancelationResponse {
	private UserDTO userDto;
	private List<ReservedMovieResponse> reservedMovies;

	public UserDTO getUserDto() {
		return userDto;
	}
	public void setUserDto(UserDTO userDto) {
		this.userDto = userDto;
	}
	public List<ReservedMovieResponse> getReservedMovies() {
		return reservedMovies;
	}
	public void setReservedMovies(List<ReservedMovieResponse> reservedMovies) {
		this.reservedMovies = reservedMovies;
	}
	@Override
	public String toString() {
		return "ReservationCancelationResponse [userDto=" + userDto + ", reservedMovies=" + reservedMovies + "]";
	}
	
	
}
