package com.bookingservice.dto;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MovieDTO {
	
	private String title;
    private String language;
    private String genre;
    private Integer duration;
    private String rating;
    private LocalDate releaseDate;
    private Double ticketPrice;

}
