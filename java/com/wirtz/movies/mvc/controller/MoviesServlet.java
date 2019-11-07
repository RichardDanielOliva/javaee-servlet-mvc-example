package com.wirtz.movies.mvc.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wirtz.movies.mvc.model.movieService.MovieService;
import com.wirtz.movies.mvc.model.movieService.MovieServiceImpl;
import com.wirtz.springmvc.model.Movie;

/**
 * Servlet implementation class ProductServlet
 */
@WebServlet("/Movies")
public class MoviesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String PARAM_MOVIE_ID="movieId";
	
	private static final String ATT_MOVIE="movie";
	private static final String ATT_MOVIES_LIST="movies";
	private static final String ATT_MOVIES_AVERAGE="moviesAverage";
	
	private static final String VIEW_MOVIE_DETAILS="MovieDetails.jsp";
	private static final String VIEW_MOVIES="Movies.jsp";
	

	
	private MovieService movieService =new MovieServiceImpl();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MoviesServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		long productId=-1;
		Movie product=null;
		
		List<Movie> productos= null;
		
		if(request.getParameter(PARAM_MOVIE_ID)!=null){
			/*Get movie and send data to the right view*/
			long id = Long.parseLong(request.getParameter(PARAM_MOVIE_ID));

			request.setAttribute(ATT_MOVIE, 
					movieService.getMovieById(id));
			
			request.getRequestDispatcher(VIEW_MOVIE_DETAILS).forward(request, response);
		}
		else {
			/*Get all movies and send data to the right view*/
			request.setAttribute(ATT_MOVIES_LIST, 
					movieService.getMovies());
			
			request.setAttribute(ATT_MOVIES_AVERAGE, 
					movieService.getAverage());
			
			request.getRequestDispatcher(VIEW_MOVIES).forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
