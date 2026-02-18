package com.movieservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.movieservice.dto.MovieDTO;
import com.movieservice.service.MovieService;

@RestController
@RequestMapping("/movie/api")
public class MovieController {

	@Autowired
	private MovieService service;
	
	@PostMapping("/save")
	public ResponseEntity<MovieDTO> savecontroller(@RequestBody MovieDTO dto){
		MovieDTO obj1 = service.moviesave(dto);
		return new ResponseEntity<>(obj1,HttpStatus.CREATED);
	}
	
	@GetMapping("/title/{title}")
	public ResponseEntity<MovieDTO> getFindByTitle(@PathVariable String title){
		MovieDTO obj2 = service.findBytitle(title);
		return new ResponseEntity<>(obj2,HttpStatus.OK);
	}
}
