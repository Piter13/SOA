package pl.marganski.soa;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/movies")
public class MovieService {
	
	static private MovieManager movieManager = new MovieManager();
	
	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getMovie(@PathParam("id") int id) {
		return movieManager.getMovies()
						.stream()
						.filter(movie -> movie.getId() == id)
						.findFirst()
						.map(movie -> Response.ok(movie).build())
						.orElse(Response.noContent().build());

	}
	
	@GET
	@Path("/")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getMovieByTitle(@QueryParam("title") String title) {
		return movieManager.getMovies()
						.stream()
						.filter(movie -> movie.getTitle().equals(title))
						.findFirst()
						.map(movie -> Response.ok(movie).build())
						.orElse(Response.noContent().build());
	}
	
	
	@DELETE
	@Path("/{id}")
	public void deleteMovie(@PathParam("id") int id) {
		movieManager.getMovies()
					    .stream()
					    .filter(_movie -> _movie.getId() == id)
					    .findFirst()
					    .ifPresent(movieManager.getMovies()::remove);
	}
	
}
