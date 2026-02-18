package com.bookingservice.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.bookingservice.dto.MovieDTO;

@FeignClient(url = "http://localhost:7070", value = "MOVIE-SERVICE")
public interface APIClient {
	
	@GetMapping("/movie/api/title/{title}")
	public MovieDTO getFindByTitle(@PathVariable String title);

}
