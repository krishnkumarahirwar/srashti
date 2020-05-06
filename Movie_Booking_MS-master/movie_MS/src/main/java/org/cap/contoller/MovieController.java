package org.cap.contoller;
import org.cap.dto.*;
import org.cap.entity.*;
import org.cap.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

@RestController
@RequestMapping("/movies")
public class MovieController {

	@Autowired
	private IMovieService service;

	@GetMapping
	public ResponseEntity<List<MovieDetailsDto>> FetchallMovies(){
		List<Movie> list=service.FetchallMovies();
		List<MovieDetailsDto> dtos=convertToDetails(list);
		ResponseEntity<List<MovieDetailsDto>> response=new ResponseEntity<>(dtos,HttpStatus.OK);
		return response;

	}


	@PostMapping("/add")
	public ResponseEntity<MovieDetailsDto> addMovie(@RequestBody MovieDetailsDto requestDto){
		Movie movie=new Movie();
		movie.setMovieId(requestDto.getMovieId());
		movie.setMovieName(requestDto.getMovieName());
		//movie.setMovieGenre(requestDto.getMovieGenre());
		//movie.setMovieDirector(requestDto.getMovieDirector());
		//movie.setMovieLength(requestDto.getMovieLength());
		//movie.setLanguage(requestDto.getLanguage());
		//movie.setReleaseDate(requestDto.getReleaseDate());
		movie=service.addMovie(movie);
		MovieDetailsDto dto=convertToDetailsDto(movie);
		ResponseEntity<MovieDetailsDto> response = new ResponseEntity<>(dto, HttpStatus.OK);
		return response;
	}


	@GetMapping("/get/{name}")
	public ResponseEntity<MovieDetailsDto> add(@PathVariable("name") String name) {
		Movie movie = service.searchMovie(name);
		MovieDetailsDto dto = convertToDetailsDto(movie);
		ResponseEntity<MovieDetailsDto> response = new ResponseEntity<>(dto, HttpStatus.OK);
		return response;
	}

	List<MovieDetailsDto> convertToDetails(Collection<Movie> movie) {
		List<MovieDetailsDto> dtos = new ArrayList<>();
		for (Movie movies : movie) {
			MovieDetailsDto dto = convertToDetailsDto(movies);
			dtos.add(dto);
		}
		return dtos;
	}


	MovieDetailsDto convertToDetailsDto(Movie movie) {
		MovieDetailsDto dto = new MovieDetailsDto();
		dto.setMovieName(movie.getMovieName());
		dto.setMovieId(movie.getMovieId());
		return dto;


	}
}
