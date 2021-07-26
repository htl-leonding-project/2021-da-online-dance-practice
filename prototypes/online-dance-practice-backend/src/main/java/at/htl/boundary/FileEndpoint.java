package at.htl.boundary;

import at.htl.control.CourseRepository;
import at.htl.control.FileRepository;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@RequestScoped
@Path("/File")
public class FileEndpoint {

    @Inject
    FileRepository fileRepository;

    @GET
    @Path("/findAll")
    @Produces(MediaType.APPLICATION_JSON)
    public Response findAll() {
        return Response.ok(fileRepository.findAll()).build();
    }

}
