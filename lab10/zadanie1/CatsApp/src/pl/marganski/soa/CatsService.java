package pl.marganski.soa;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/cats")
public class CatsService {

	private CatShelter shelter = new CatShelter();

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Cat> getCats() {
		return shelter.getCats();
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{id}")
	public Cat getCat(@PathParam("id") int id) {
		return shelter.getCats().stream().filter(cat -> cat.getId() == id).findAny().get();
	}
	
	@POST
        @Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
        public List<Cat> saveCats(List<Cat> cats) {
		shelter.save(cats);
		return shelter.getCats();
        }
	
	@PUT
	@Path("/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public List<Cat> updateCat(@PathParam("id") int id, Cat cat){
		cat.setId(id);
        	shelter.update(id, cat);
        	return shelter.getCats();
    	}

	@DELETE
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Cat> removeCat(@PathParam("id") int id) {
		shelter.remove(id);
		return shelter.getCats();
	}

}
