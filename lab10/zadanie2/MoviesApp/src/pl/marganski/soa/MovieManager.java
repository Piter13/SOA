package pl.marganski.soa;

import java.util.ArrayList;
import java.util.List;

public class MovieManager {
	private List<Movie> movies = new ArrayList<Movie>();

	public MovieManager() {
		movies.add(new Movie(1, "The Godfather"));
		movies.add(new Movie(2, "Rocky"));
		movies.add(new Movie(3, "Sherlock"));
	}

	public List<Movie> getMovies() {
		return movies;
	}

	public void setMovies(List<Movie> movies) {
		this.movies = movies;
	}

}
