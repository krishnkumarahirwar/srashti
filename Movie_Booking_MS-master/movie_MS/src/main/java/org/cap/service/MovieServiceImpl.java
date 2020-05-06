package org.cap.service;
import org.cap.dao.IMovieDao;
import org.cap.entity.*;
import org.cap.exception.*;
import org.cap.util.MovieValidation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
@Transactional
public class MovieServiceImpl implements IMovieService {
	private IMovieDao dao;
	
	public IMovieDao getDao() {
		return dao;
	}
	
	@Autowired
	public void setDao(IMovieDao dao) {
		this.dao=dao;
	}

	@Override
	public Movie addMovie(Movie movie) {
		if(movie==null){
            throw new IncorrectArgumentException("Movie can't be null");
		}
        	Movie mov=dao.save(movie);
		
		MovieValidation.validateId(movie.getMovieId());
		return mov;
	}

	//@Override
	//public Movie searchMovie(String movieName) {
	//	if(movieName==null) {
	//		throw new IncorrectArgumentException("Movie name should not be null");
	//	}
	//	
	//	if (movieName.isEmpty()) {
	//		throw new MovieNotFoundException("Movie not found");
	//	}
		
	//	Movie movie = movieName.get
	//	return movie;
    //throw new IncorrectArgumentException("Movie with this name does not exist");
	//	}
	
	 @Override
	    public Movie findByMovieName(String movieName) {
	     Optional<Movie>optional=dao.findByMovieName(movieName);
	     if(optional.isPresent()){
	         Movie movie=optional.get();
	         return movie;
	     }
	     throw new MovieNotFoundException("movie is not found for movie name"+movieName);
	    }
	 
	 
	/*@Override
	public void deleteMovie(int movieId) {
		if(movieId==0)
			throw new IncorrectArgumentException("Movie id cannot be 0(ZERO)");

		dao.deleteById(movieId);
	}*/
	 
	 @Override
		public void deleteMovie(String movieName) {
		 if(movieName==null) {
			throw new IncorrectArgumentException("Movie name should not be null");
			}
			
		if (movieName.isEmpty()) {
			throw new MovieNotFoundException("Movie not found");
			}

			dao.deleteByMovieName(movieName);
		}

	@Override
	public List<Movie> FetchallMovies() {
		List<Movie> movies = dao.findAll();
        return movies;
	}

	}
