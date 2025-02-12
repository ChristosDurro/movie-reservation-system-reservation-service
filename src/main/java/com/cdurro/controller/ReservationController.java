package com.cdurro.controller;

import org.springframework.web.bind.annotation.RestController;

import com.cdurro.dto.ReservationCancelationRequest;
import com.cdurro.dto.ReservationCancelationResponse;
import com.cdurro.dto.ReservationRequest;
import com.cdurro.dto.ReservationResponse;
import com.cdurro.dto.ReservedMovieResponse;
import com.cdurro.service.ReservationService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
public class ReservationController {
	
	@Autowired
	private ReservationService reservationService;
	
	@GetMapping("/reservations/{userId}")
	public ResponseEntity<List<ReservedMovieResponse>> getBookings(@PathVariable Long userId) {
		
		return reservationService.getBookings(userId);
	}
	
	@PostMapping("/reservations/book")
	public ResponseEntity<ReservationResponse> book(@RequestBody ReservationRequest request) {
		
		return reservationService.createBooking(request);
	}
	
	@PostMapping("/reservations/cancel")
	public ReservationCancelationResponse cancelReservation(@RequestBody ReservationCancelationRequest request) {
		
		return reservationService.cancelReservation(request);
	}
	
}
