package com.cdurro.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.cdurro.dto.UserDTO;
import com.cdurro.model.User;

@FeignClient("USER-SERVICE")
public interface UserClient {

	@GetMapping("/users/id/{id}")
	public User getUserById(@PathVariable Long id);
	
	@PutMapping("/users/update/{id}")
	public ResponseEntity<User> updateUser(@PathVariable Long id, @RequestBody UserDTO user);
}
