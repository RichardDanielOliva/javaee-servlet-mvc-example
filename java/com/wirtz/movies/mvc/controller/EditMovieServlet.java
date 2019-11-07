package com.wirtz.movies.mvc.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wirtz.movies.mvc.model.movieService.MovieService;
import com.wirtz.movies.mvc.model.movieService.MovieServiceImpl;
import com.wirtz.movies.mvc.util.FeedbackMessage;

/**
 * Servlet implementation class EditServlet
 */
@WebServlet("/EditMovie")
public class EditMovieServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static final String ATT_MOVIE = "movie";
	private static final String ATT_MSG_FEEDBACK = "feedback";

	private static final String PARAM_MOVIE_ID = "movieId";
	private static final String PARAM_PUNTUACION = "puntuacion";

	private static final String VIEW_EDIT_MOVIE = "MovieDetailsEditForm.jsp";
	private static final String VIEW_DETAILS_MOVIE = "MovieDetails.jsp";

	private static final String VIEW_MOVIES = "Movies";

	private MovieService movieService;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public EditMovieServlet() {
		super();
		movieService = new MovieServiceImpl();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		if (request.getParameter(PARAM_MOVIE_ID) != null) {
			long idMovie = Long.parseLong(request.getParameter(PARAM_MOVIE_ID));
			/* Get movie and send to the right view */
			Movie movie = movieService.getMovieById(idMovie);
			request.setAttribute(ATT_MOVIE, movie);
			request.getRequestDispatcher(VIEW_EDIT_MOVIE).forward(request, response);
		} else {
			/* send to the Movies servlet */
			request.setAttribute(VIEW_MOVIES, 
					movieService.getMovies());
			
			request.getRequestDispatcher(VIEW_MOVIES).forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		
		long movieId = 0;
		
		FeedbackMessage fmsg = new FeedbackMessage();
		try {
			if (request.getParameter(PARAM_MOVIE_ID) != null) {
				/* Get data from param request and update model */
				long id = Long.parseLong(request.getParameter(PARAM_MOVIE_ID));
				float score = Float.parseFloat(request.getParameter(PARAM_PUNTUACION));
				
				movieService.updateMovie(id, score);
				
				/* Además, preparar un mensaje para el usuario */
				fmsg.setMessage("Movie updated correctly");

				request.setAttribute(ATT_MSG_FEEDBACK, fmsg);

				request.getRequestDispatcher(VIEW_MOVIES).forward(request, response);
			}
		} catch (Exception ex) {
			fmsg.setMessage("An unexpected error has occurred" + ex.getMessage());
			fmsg.setError(true);

			request.setAttribute(ATT_MSG_FEEDBACK, fmsg);
			request.getRequestDispatcher(VIEW_EDIT_MOVIE + "?" + movieId).forward(request, response);
		}

	}

}
