package pl.marganski.movies.lab3;

import pl.marganski.movies.lab3.Movie;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MoviesServlet
 */
@WebServlet("/MoviesServlet")
public class MoviesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public MoviesServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		Movie movie = new Movie();
		ArrayList<Movie> movies = movie.getMovies();

		request.setAttribute("movies", movies);
		RequestDispatcher view = request.getRequestDispatcher("moviesTable.jsp");
		view.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}
	
}
