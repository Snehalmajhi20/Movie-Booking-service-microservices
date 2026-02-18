package com.movieservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.movieservice.dto.MovieDTO;
import com.movieservice.entity.Movie;
import com.movieservice.repository.MovieRepo;

@Service

public class MovieServiceImpl implements MovieService{
	
	@Autowired
	private MovieRepo repo;

	@Override
	public MovieDTO moviesave(MovieDTO movieDTO) {
		Movie movie = new Movie();
		movie.setTitle(movieDTO.getTitle());
		movie.setLanguage(movieDTO.getLanguage());
		movie.setGenre(movieDTO.getGenre());
		movie.setDuration(movieDTO.getDuration());
		movie.setRating(movieDTO.getRating());
		movie.setReleaseDate(movieDTO.getReleaseDate());
		movie.setTicketPrice(movieDTO.getTicketPrice());
		Movie obj1 = repo.save(movie);
		return new MovieDTO(
				obj1.getTitle(), obj1.getLanguage(), obj1.getGenre(), obj1.getDuration(), obj1.getRating(),
				obj1.getReleaseDate(), obj1.getTicketPrice()
				);
	}

	@Override
	public MovieDTO findBytitle(String title) {
		Movie obj2 = repo.findBytitle(title);
		return new MovieDTO(
				obj2.getTitle(), obj2.getLanguage(), obj2.getGenre(), obj2.getDuration(), obj2.getRating(),
				obj2.getReleaseDate(), obj2.getTicketPrice()
				);
	}

}
