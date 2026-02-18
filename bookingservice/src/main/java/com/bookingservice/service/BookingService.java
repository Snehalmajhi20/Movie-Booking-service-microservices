package com.bookingservice.service;

import com.bookingservice.dto.ApiResponseDTO;
import com.bookingservice.dto.BookingDTO;

public interface BookingService {
	
	public BookingDTO savebooking(BookingDTO bookingDTO);
	public ApiResponseDTO getBookingId(Long id);

}
