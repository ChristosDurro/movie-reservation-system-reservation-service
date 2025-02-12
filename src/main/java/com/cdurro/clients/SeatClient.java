package com.cdurro.clients;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.cdurro.model.Seat;

@FeignClient("SEAT-SERVICE")
public interface SeatClient {
	
	@PostMapping("/seats/multiple")
	public ResponseEntity<List<Seat>> getMultipleSeats(@RequestBody List<Long> scheduleIds);

	@PutMapping("/seats/availability/reset/{id}")
	public Seat resetSeatAvailability(@PathVariable Long id);
}
