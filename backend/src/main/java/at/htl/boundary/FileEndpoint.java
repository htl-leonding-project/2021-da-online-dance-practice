package at.htl.boundary;

import at.htl.control.FileRepository;
import at.htl.control.UsageRepository;
import at.htl.entity.D_File;
import com.thoughtworks.xstream.io.path.Path;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import java.net.URI;
import javax.json.*;

@RequestScoped
@Path("/file")
public class FileEndpoint {

    @Inject
    FileRepository fileRepository;

    @Inject
    UsageRepository usageRepository;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response findall() {
        return Response.ok(fileRepository.listAll()).build();
        /*JsonObject hello = Json.createObjectBuilder().add("name", "sandy").build();
        return Response.ok(hello).build();*/
    }

    @POST
    @Path("/create")
    @Transactional
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response create(D_File file, @Context UriInfo info) {
        fileRepository.persist(file);
        return Response.created(URI.create(info.getPath() + "/"+ file.id)).build();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response findById(@PathParam("id") long id) {
        return Response.ok(fileRepository.findById(id)).build();
    }

    @DELETE
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Transactional
    public Response delete(@PathParam("id") Long id) {
        try {

            //usageRepository.find("select * from usage u where u.file = )

            fileRepository.delete(fileRepository.findById(id));
            return Response
                    .noContent()
                    .build();
        } catch (IllegalArgumentException e) {
            return Response
                    .status(400)
                    .header("Reason","File with id" +id  + "does not exist")
                    .build();
        }
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response uploadfile(D_File file) {
        return Response.ok(fileRepository.persist(file)).build();
    }
}
