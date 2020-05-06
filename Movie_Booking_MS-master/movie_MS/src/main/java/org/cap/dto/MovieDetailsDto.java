package org.cap.dto;

import java.util.Date;
import java.util.List;

public class MovieDetailsDto {
	private int movieId;

	public int getMovieId() {
		return movieId;
	}
	public void setMovieId(int movieId) {
		this.movieId = movieId;
	}


	private String movieName;
    public String getMovieName() {
		return movieName;
	}
	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}


	private String movieDirector;
    public String getMovieDirector() {
		return movieDirector;
	}
	public void setMovieDirector(String movieDirector) {
		this.movieDirector = movieDirector;
	}


	private int movieLength;
	public int getMovieLength() {
		return movieLength;
	}
	public void setMovieLength(int movieLength) {
		this.movieLength = movieLength;
	}


	private Date releaseDate;
    public Date getReleaseDate() {
		return releaseDate;
	}
	public void setReleaseDate(Date releaseDate) {
		this.releaseDate = releaseDate;
	}



	private List<String> movieGenre;
    public List<String> getMovieGenre() {
		return movieGenre;
	}
	public void setMovieGenre(List<String> movieGenre) {
		this.movieGenre = movieGenre;
	}


	private List<String> language;
    public List<String> getLanguage() {
		return language;
	}
	public void setLanguage(List<String> language) {
		this.language = language;
	}


}
