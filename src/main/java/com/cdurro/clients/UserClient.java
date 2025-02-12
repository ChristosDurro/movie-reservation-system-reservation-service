package com.cdurro.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.cdurro.model.User;

@FeignClient("USER-SERVICE")
public interface UserClient {

	@GetMapping("/users/id/{id}")
	public User getUserById(@PathVariable Long id);
}
