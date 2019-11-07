package com.wirtz.movies.mvc.model.movieService;

import java.util.List;

import com.wirtz.springmvc.model.Movie;

public interface MovieService {

	public List<Movie> getMovies();
	
	public Movie getMovieById(long id);
	
	public Movie createMovie(String name, float puntuacion, int duracion);
	
	public Movie updateMovie(long id, float score);
	
	public double getAverage();
}
