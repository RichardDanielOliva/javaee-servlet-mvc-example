package com.wirtz.movies.mvc.model.movieService;

import java.util.List;

import com.wirtz.springmvc.model.Movie;
import com.wirtz.springmvc.model.MovieDAO;
import com.wirtz.springmvc.model.MovieDAOHashmapImpl;

public class MovieServiceImpl implements MovieService {

	private MovieDAO productDAO = new MovieDAOHashmapImpl();

	@Override
	public List<Movie> getMovies() {

		return productDAO.getMovies();
	}

	@Override
	public Movie getMovieById(long id) {

		return productDAO.getMovieById(id);
	}

	@Override
	public Movie updateMovie(long id, float score) {
		Movie m = productDAO.getMovieById(id);
		m.setPuntuacion(score);
		return productDAO.update(m);
	}

	@Override
	public double getAverage() {
		return productDAO.getMovies()
						.stream()
						.mapToDouble(Movie::getPuntuacion)
						.average()
						.getAsDouble();
	}

	@Override
	public Movie createMovie(String name, float puntuacion, int duracion) {
		// TODO Auto-generated method stub
		return productDAO.createMovie(name, puntuacion, duracion);
	}

}
