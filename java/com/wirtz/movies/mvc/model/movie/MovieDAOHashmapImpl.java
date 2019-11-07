package com.wirtz.movies.mvc.model.movie;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MovieDAOHashmapImpl implements MovieDAO {

	private static HashMap<Long, Movie> movies;

	/*In a Java class, a static block is a set of instructions that is run only once when a class is 
	 * loaded into memory. A static block is also called a static initialization block. This is because it 
	 * is an option for initializing or setting up the class at run-time.
	 */
	static {
		movies = new HashMap<Long, Movie>();
		Movie p = new Movie();
		p.setId(1);
		p.setName("Jocker");
		p.setPuntuacion(8.5f);
		
		p.setDuracion(200);

		movies.put(p.getId(), p);

		p = new Movie();
		p.setId(2);
		p.setName("Mientras dure la guerra");
		p.setPuntuacion(6.3f);
		p.setDuracion(99);
		
		movies.put(p.getId(), p);
		

		p = new Movie();
		p.setId(3);
		p.setName("Maléfica");
		p.setPuntuacion(1.3f);
		p.setDuracion(111);
		movies.put(p.getId(), p);

		p = new Movie();
		p.setId(4);
		p.setName("Proyecto Géminis");
		p.setPuntuacion(5.8f);
		p.setDuracion(89);
		movies.put(p.getId(), p);

	}

	@Override
	public List<Movie> getMovies() {
		return new ArrayList<Movie>( movies.values());
	}

	@Override
	public Movie getMovieById(long id) {
		return movies.get(id);
	}

	@Override
	public Movie update(Movie m) {
		movies.put(m.getId(), m);
		return movies.get(m.getId());
	}
	
	@Override
	public Movie createMovie(String name, float puntuacion, int duracion) {
		Movie p = new Movie();
		
		p.setId(getNextId());
		p.setName(name);
		p.setPuntuacion(puntuacion);
		p.setDuracion(duracion);
		movies.put(p.getId(), p);
		
		return p;
	}
	
	private long getNextId() {
		return getMovies()
			.stream()
			.mapToLong(movie -> movie.getId())
			.max()
			.getAsLong() + 1;
	}
}
