package pl.marganski.movies.lab3;

import java.util.ArrayList;

public class Movie {

	String title;
	String genre;
	String year;
	int income;
	
	public Movie() {}

	public Movie(String title, String genre, String year, int income) {
		this.title = title;
		this.genre = genre;
		this.year = year;
		this.income = income;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public int getIncome() {
		return income;
	}

	public void setIncome(int income) {
		this.income = income;
	}
	
	public ArrayList<Movie> getMovies() {

		ArrayList<Movie> movies = new ArrayList<Movie>();

		movies.add(new Movie("Dallas Buyers Club", "dramat", "2013", 55736588));
		movies.add(new Movie("Fury", "wojenny", "2014", 211817906));
		movies.add(new Movie("Collateral Beauty", "dramat", "2016", 88216021));
		movies.add(new Movie("The Godfather", "gangsterski", "1972", 245066411));

		return movies;
	}

}