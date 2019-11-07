package com.wirtz.movies.mvc.model.movie;

import java.util.List;

public interface MovieDAO {

	public List<Movie> getMovies();
	
	public Movie getMovieById(long id);

	public Movie update(Movie m);

	public Movie createMovie(String name, float puntuacion, int duracion);
}
