package com.movieservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.movieservice.entity.Movie;

public interface MovieRepo extends JpaRepository<Movie, Long>{
	
	Movie findBytitle(String title);

}
