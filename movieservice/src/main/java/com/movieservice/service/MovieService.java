package com.movieservice.service;

import com.movieservice.dto.MovieDTO;

public interface MovieService {
	
	public MovieDTO moviesave(MovieDTO movieDTO);
	public MovieDTO findBytitle(String title);

}
