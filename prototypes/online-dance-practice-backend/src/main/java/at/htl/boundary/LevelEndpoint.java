package at.htl.boundary;

import at.htl.control.LevelRepository;
import at.htl.entity.Level;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import java.net.URI;

@RequestScoped
@Path("/Level")
public class LevelEndpoint {

    @Inject
    LevelRepository levelRepository;

    @GET
    @Path("/findAll")
    @Produces(MediaType.APPLICATION_JSON)
    public Response findAll() {
        return Response.ok(levelRepository.findAll()).build();
    }


    @POST
    @Path("/create")
    @Transactional
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response create(Level level, @Context UriInfo info) {
        levelRepository.persist(level);
        return Response.created(URI.create(info.getPath() + "/"+ level.levelId)).build();
    }



}
