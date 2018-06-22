package pl.marganski.soa.rest.controllers;

import java.util.List;
import java.util.Optional;

import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import pl.marganski.soa.ejb.services.*;
import pl.marganski.soa.jpa.entities.*;
import pl.marganski.soa.jpa.entities.dto.MagDTO;
import pl.marganski.soa.rest.controllers.auth.Authentication;

@Path("/mags")
public class MagController {

	@EJB
	private MagService magService;
	
	@EJB
	private Authentication authentication;

	@GET
    @Path("/")
	@Produces(MediaType.APPLICATION_JSON)
    public List<MagDTO> getAllMags() {
        return magService.getAllMagsDTOs();
	}
	
	@GET
    @Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
    public Response getMagById(@PathParam("id") int id) {
        return Optional.ofNullable(Response.ok(magService.getMagDTO(id)))
        				.orElse(Response.noContent())
        				.build();
	}
	
	@POST
	@Path("/")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response addMag(MagDTO magDTO, @HeaderParam("Authorization") String authorizationString) {
		if (!authentication.isAuthorized(authorizationString)) {
			return Response.status(401).build();
		}
		magService.saveMag(magDTO);
        return Response.ok().build();
	}
	
	@PUT
	@Path("/")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response updateMag(Mag mag) {
        return Response.ok().build();
	}
	
	@DELETE
	@Path("/{id}")
	public Response deleteMag(@PathParam("id") int id) {
		magService.removeMag(id);
		return Response.ok().build();
	}

}
