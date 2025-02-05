package com.cdurro.clients;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.cdurro.model.Movie;

@FeignClient("movie-service")
public interface MovieClient {

	@PostMapping("movies/multiple")
	public ResponseEntity<List<Movie>> multipleMovies(@RequestBody List<Long> movieIds);
}
