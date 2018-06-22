package pl.marganski.soa.rest.controllers;

import java.util.List;

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

import pl.marganski.soa.ejb.services.CastleService;
import pl.marganski.soa.jpa.entities.Castle;
import pl.marganski.soa.jpa.entities.dto.CastleDTO;
import pl.marganski.soa.rest.controllers.auth.Authentication;

@Path("/castles")
public class CastleController {

	@EJB
	private CastleService castleService;
	
	@EJB
	private Authentication authentication;

	@GET
	@Path("/")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Castle> getAllCastles() {
		return castleService.getAllCastles();
	}

	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getCastleById(@PathParam("id") int id) {
		return Response.ok(castleService.getCastleDTO(id)).build();
	}

	@POST
	@Path("/")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response addCastle(CastleDTO castleDTO, @HeaderParam("Authorization") String authorizationString) {
			if(!authentication.isAuthorized(authorizationString)) {
				return Response.status(401).build();
			}
		castleService.addCastle(castleDTO);
		return Response.ok().build();
	}

	@PUT
	@Path("/")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response updateCastle(CastleDTO castleDTO) {
		castleService.updateCastle(castleDTO);
		return Response.ok().build();
	}

	@DELETE
	@Path("/{id}")
	public Response deleteCastle(@PathParam("id") int id) {
		castleService.removeCastle(id);
		return Response.ok().build();
	}
}
