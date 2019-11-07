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
 * Servlet implementation class CreateMovieServlet
 */
@WebServlet("/CreateMovie")
public class CreateMovieServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private static final String ATT_MSG_FEEDBACK = "feedback";
     
	private static final String PARAM_MOVIE_NAME = "name";
	private static final String PARAM_MOVIE_PUNTUACION = "puntuacion";
	private static final String PARAM_MOVIE_DURACION = "duracion";

	private static final String VIEW_NEW_MOVIE = "NewMovieForm.jsp";
	private static final String VIEW_MOVIES = "Movies";
	
	private MovieService movieService;

    public CreateMovieServlet() {
		super();
		movieService = new MovieServiceImpl();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher(VIEW_NEW_MOVIE).forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		FeedbackMessage fmsg = new FeedbackMessage();
		
		try {
				String name = request.getParameter(PARAM_MOVIE_NAME);
				int duracion = Integer.parseInt(request.getParameter(PARAM_MOVIE_DURACION));
				float puntuacion = Float.parseFloat(request.getParameter(PARAM_MOVIE_PUNTUACION));
				
				movieService.createMovie(name, puntuacion, duracion);

				request.setAttribute(ATT_MSG_FEEDBACK, fmsg);
				request.getRequestDispatcher(VIEW_MOVIES).forward(request, response);
		} catch (Exception ex) {
			fmsg.setMessage("An unexpected error has occurred" + ex.getMessage());
			fmsg.setError(true);

			request.setAttribute(ATT_MSG_FEEDBACK, fmsg);
			request.getRequestDispatcher(VIEW_NEW_MOVIE).forward(request, response);
		}
	}

}
