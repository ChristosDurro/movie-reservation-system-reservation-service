package com.cdurro.clients;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.cdurro.model.Ticket;

@FeignClient("TICKET-SERVICE")
public interface TicketClient {
	
	@GetMapping("/tickets/user/{userId}")
	public ResponseEntity<List<Ticket>> getAllTicketsByUser(@PathVariable Long userId);

	@DeleteMapping("/tickets/delete/{id}")
	public Ticket deleteTicket(@PathVariable Long id);
}
