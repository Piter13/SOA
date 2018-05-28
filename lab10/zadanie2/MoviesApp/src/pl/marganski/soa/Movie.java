package pl.marganski.soa;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Movie {
	private int id;
	private String title;
	private String uri;

	public Movie() {}

	public Movie(int id, String title) {
		this.id = id;
		this.title = title;
		this.uri = "http://localhost:8080/MoviesApp/rest/movies/" + id;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getUri() {
		return uri;
	}

	public void setUri(String uri) {
		this.uri = uri;
	}
}
