package org.cap.service;
import org.cap.entity.*;
import java.util.Collection;
import java.util.List;



public interface IMovieService {

	//CREATING METHODS

	Movie addMovie(Movie movie);

	//Movie searchMovie(String movieName);

	//void deleteMovie(int movieId);

	List<Movie> FetchallMovies();

	Movie findByMovieName(String movieName);

	void deleteMovie(String movieName);

}
