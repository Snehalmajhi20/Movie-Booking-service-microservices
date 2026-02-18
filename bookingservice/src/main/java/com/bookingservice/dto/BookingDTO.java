package com.bookingservice.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class BookingDTO {
	
	private String userName;
    private String title;
    private Integer numberOfTickets;
    private Double totalAmount;

}
