package com.cdurro.clients;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.cdurro.model.Ticket;

@FeignClient("TICKET-SERVICE")
public interface TicketClient {

	@GetMapping("/tickets/user/{userId}")
	public ResponseEntity<List<Ticket>> getAllTicketsByUser(@PathVariable Long userId);
	
	@PostMapping("/tickets/multiple/create")
	public ResponseEntity<List<Ticket>> createTickets(@RequestBody List<Ticket> tickets);

	@DeleteMapping("/tickets/delete/{id}")
	public Ticket deleteTicket(@PathVariable Long id);
}
