package com.bookingservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bookingservice.dto.ApiResponseDTO;
import com.bookingservice.dto.BookingDTO;
import com.bookingservice.service.BookingService;

@RestController
@RequestMapping("/booking/api")
public class BookingController {
	
	@Autowired
	private BookingService service;
	
	@PostMapping("/save")
	public ResponseEntity<BookingDTO> saved(@RequestBody BookingDTO dto){
		BookingDTO obj1 = service.savebooking(dto);
		return new ResponseEntity<>(obj1, HttpStatus.CREATED);
	}
	
	@GetMapping("/bookingid/{id}")
	public ResponseEntity<ApiResponseDTO> getFindbyId(@PathVariable Long id){
		ApiResponseDTO obj2 = service.getBookingId(id);
		return new ResponseEntity<>(obj2, HttpStatus.OK);
	}

}
