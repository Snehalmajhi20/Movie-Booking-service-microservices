package com.bookingservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.bookingservice.dto.ApiResponseDTO;
import com.bookingservice.dto.BookingDTO;
import com.bookingservice.dto.MovieDTO;
import com.bookingservice.entity.Booking;
import com.bookingservice.repository.BookingRepo;

@Service

public class BookingServiceImpl implements BookingService{
	
	@Autowired
	private BookingRepo repo;
	
//	@Autowired
//	private WebClient webClient;
	
	@Autowired
	private APIClient apiClient;

	@Override
	public BookingDTO savebooking(BookingDTO bookingDTO) {
		Booking obj1 = new Booking();
		obj1.setUserName(bookingDTO.getUserName());
		obj1.setTitle(bookingDTO.getTitle());
		obj1.setNumberOfTickets(bookingDTO.getNumberOfTickets());
		obj1.setTotalAmount(bookingDTO.getTotalAmount());
		Booking t1 = repo.save(obj1);
		return new BookingDTO(
				t1.getUserName(), t1.getTitle(), t1.getNumberOfTickets(), t1.getTotalAmount()
				) ;
	}

	@Override
	public ApiResponseDTO getBookingId(Long id) {
		Booking obj2 = repo.findById(id).orElseThrow(() -> new RuntimeException("Booking not found!"));
		
		// WebClient 
		
//		MovieDTO movieDTO =  webClient.get()
//				.uri("http://localhost:7070/movie/api/title/"+obj2.getTitle()).retrieve().bodyToMono(MovieDTO.class)
//				.block();
		
		// OpenFeign
		
		MovieDTO movieDTO = apiClient.getFindByTitle(obj2.getTitle());
		BookingDTO bookingDTO = new BookingDTO(
				obj2.getUserName(), obj2.getTitle(), obj2.getNumberOfTickets(), obj2.getTotalAmount()
				);
		ApiResponseDTO apiResponseDTO = new ApiResponseDTO();
		apiResponseDTO.setBookingDTO(bookingDTO);
		apiResponseDTO.setMovieDTO(movieDTO);
		return apiResponseDTO;
	}

}
