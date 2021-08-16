package at.htl.boundary;

import at.htl.control.UsageRepository;
import at.htl.entity.Usage;

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
@Path("/usage")
public class UsageEndpoint {

    @Inject
    UsageRepository usageRepository;

    @GET
    @Path("/findall")
    @Produces(MediaType.APPLICATION_JSON)
    public Response findAll() {
        return Response.ok(usageRepository.findAll()).build();
    }

    @POST
    @Path("/create")
    @Transactional
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response create(Usage usage, @Context UriInfo info) {
        usageRepository.persist(usage);
        return Response.created(URI.create(info.getPath() + "/"+ usage.id)).build();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response findById(@PathParam("id") long id) {
        return Response.ok(usageRepository.findById(id)).build();
    }

    @DELETE
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Transactional
    public Response delete(@PathParam("id") Long id) {
        try {
            usageRepository.deleteById(id);
            return Response
                    .noContent()
                    .build();
        } catch (IllegalArgumentException e) {
            return Response
                    .status(400)
                    .header("Reason","Usage with id" + id  + "does not exist")
                    .build();
        }
    }
}
