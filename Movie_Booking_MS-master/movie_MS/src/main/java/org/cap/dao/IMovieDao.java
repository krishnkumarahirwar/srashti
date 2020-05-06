package org.cap.dao;

import java.util.List;
import java.util.Optional;

import org.cap.dto.*;
import org.cap.entity.*;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IMovieDao extends JpaRepository<Movie,String> {

	Optional<Movie> findByMovieName(String movieName);

	void deleteById(int movieId);

	void deleteByMovieName(String movieName);

	

	//CREATING METHODS


	
	
}
