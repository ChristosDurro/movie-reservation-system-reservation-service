package com.cdurro.service;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.cdurro.clients.MovieClient;
import com.cdurro.clients.ScheduleClient;
import com.cdurro.clients.SeatClient;
import com.cdurro.clients.TicketClient;
import com.cdurro.clients.UserClient;
import com.cdurro.dto.ReservationCancelationRequest;
import com.cdurro.dto.ReservationCancelationResponse;
import com.cdurro.dto.ReservationRequest;
import com.cdurro.dto.ReservationResponse;
import com.cdurro.dto.ReservedMovieResponse;
import com.cdurro.dto.SeatAvailabilityDTO;
import com.cdurro.dto.UserDTO;
import com.cdurro.model.Movie;
import com.cdurro.model.Schedule;
import com.cdurro.model.Seat;
import com.cdurro.model.Ticket;
import com.cdurro.model.User;

@Service
public class ReservationService {

	@Autowired
	private SeatClient seatClient;
	
	@Autowired
	private TicketClient ticketClient;
	
	@Autowired
	private UserClient userClient;

	@Autowired
	private MovieClient movieClient;
	
	@Autowired
	private ScheduleClient scheduleClient;

	public ResponseEntity<ReservationResponse> createBooking(ReservationRequest request) {
		System.out.println("reservation called");
		try {
			
			ReservationResponse res = new ReservationResponse();
			
			System.out.println("Reached 1");
			
			// 1. Create Tickets
			List<Ticket> tickets = ticketClient.createTickets(request.getTicketsList()).getBody();

			System.out.println("Reached 2");
			// 2. Update Seats availability
			SeatAvailabilityDTO seatAvailabilityDTO = new SeatAvailabilityDTO();
			
			seatAvailabilityDTO.setSeatIdsToUpdate(request.getSeats().getSeatIdsToUpdate());
			seatAvailabilityDTO.setAvailability(request.getSeats().getAvailability());
			
			List<Seat> seats = seatClient.updateMultipleSeats(seatAvailabilityDTO).getBody();
			

			System.out.println("Reached 3");
			// 3. Update User Ticket List
			UserDTO userDto = new UserDTO(
					request.getUser().getId(),
					request.getUser().getFirstName(),
					request.getUser().getLastName(),
					request.getUser().getUsername(),
					request.getUser().getEmail()
			);

			System.out.println("Reached 3.5");
			userClient.updateUser(userDto.getId(), userDto);

			System.out.println("Reached 4");
			res.setSuccess(true);
			res.setMessage("Reservation successful");
			res.setTicketIds(tickets.stream().map(Ticket::getId).toList());
			res.setSeatIds(seats.stream().map(Seat::getId).toList());
			res.setUserId(userDto.getId());

			System.out.println("Reached 5");
			return ResponseEntity.ok(res);
		}
		catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(
					new ReservationResponse(
							false,
							"Reservation failed: " + e.getMessage()));
		}
		
	}

	public ResponseEntity<List<ReservedMovieResponse>> getBookings(Long userId) {
		
		List<Ticket> tickets = ticketClient.getAllTicketsByUser(userId).getBody();
		
		
		// Fetch all movies, schedules, seats in one go
		List<Long> movieIds = tickets.stream().map(Ticket::getMovieId).toList();
		List<Long> scheduleIds = tickets.stream().map(Ticket::getScheduleId).toList();
		List<Long> seatIds = tickets.stream().map(Ticket::getSeatId).toList();
		
		
		// Fetch all different movies, seats, schedules a user has
		Map<Long, Movie> movies = movieClient.multipleMovies(movieIds).getBody().stream().collect(
				Collectors.toMap(Movie::getId, Function.identity()));
		
		Map<Long, Schedule> schedules = scheduleClient.getMultipleSchedules(scheduleIds).getBody().stream().collect(
				Collectors.toMap(Schedule::getId, Function.identity()));
		
		Map<Long, Seat> seats = seatClient.getMultipleSeats(seatIds).getBody().stream().collect(
				Collectors.toMap(Seat::getId, Function.identity()));
		
		
		return ResponseEntity.ok(tickets.stream().map(ticket -> new ReservedMovieResponse(
				ticket.getId(),
				movies.get(ticket.getMovieId()),
				schedules.get(ticket.getScheduleId()),
				seats.get(ticket.getSeatId())
				)).collect(Collectors.toList()));
	}

	public ReservationCancelationResponse cancelReservation(ReservationCancelationRequest request) {
		
		User user = userClient.getUserById(request.getUserId());
		
		seatClient.resetSeatAvailability(request.getSeatId());
		
		ticketClient.deleteTicket(request.getTicketId());
		
		List<Ticket> tickets = ticketClient.getAllTicketsByUser(request.getUserId()).getBody();
		
		UserDTO userDto = new UserDTO(
				user.getId(),
				user.getFirstName(),
				user.getLastName(),
				user.getUsername(),
				user.getEmail()
		);
		
		userClient.updateUser(userDto.getId(), userDto);
		
		ReservationCancelationResponse response = new ReservationCancelationResponse();
		
		response.setUserDto(userDto);
		response.setReservedMovies(getBookings(userDto.getId()).getBody());
		
		return response;
	}
}
