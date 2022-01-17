package at.htl.boundary;

import at.htl.control.FileRepository;
import at.htl.entity.D_File;
import org.apache.commons.io.IOUtils;
import org.jboss.resteasy.plugins.providers.multipart.InputPart;
import org.jboss.resteasy.plugins.providers.multipart.MultipartFormDataInput;

import javax.annotation.security.RolesAllowed;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.json.Json;
import javax.json.JsonObjectBuilder;
import javax.ws.rs.*;
import javax.ws.rs.core.*;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;

@RequestScoped
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Path("/file")
public class FileEndpoint {

    @Inject
    FileRepository fileRepository;

    @Context
    HttpHeaders requestHeaders;

    @GET
    @Path("/findall")
    @RolesAllowed("TEACHER")
    public Response findAll() {
        return Response.ok(fileRepository.listAll()).build();
    }

    /**
     * https://mkyong.com/webservices/jax-rs/file-upload-example-in-resteasy/
     */
    @POST
    @Consumes(MediaType.MULTIPART_FORM_DATA)
    @Path("/")
    @RolesAllowed("TEACHER")
    public Response uploadFile(MultipartFormDataInput input, @Context UriInfo uri) throws IOException {
        String fileName;
        D_File file = null;

        Map<String, List<InputPart>> uploadForm = input.getFormDataMap();
        List<InputPart> inputParts = uploadForm.get("file");

        for (InputPart inputPart : inputParts) {
            try {
                MultivaluedMap<String, String> header = inputPart.getHeaders();
                fileName = fileRepository.getFileName(header);

                //convert the uploaded file to input stream
                InputStream inputStream = inputPart.getBody(InputStream.class, null);

                byte[] bytes = IOUtils.toByteArray(inputStream);

                file = fileRepository.writeFile(bytes, fileName);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        if (file != null) {
            JsonObjectBuilder builder = Json.createObjectBuilder()
                    .add("fileId", file.id);
            return Response
                    .ok(builder.build())
                    .build();
        } else {
            return Response.status(Response.Status.BAD_REQUEST)
                    .entity("the file could not be persisted")
                    .build();
        }
    }

    @GET
    @Path("{id}")
    @RolesAllowed({"STUDENT","TEACHER"})
    public Response findById(@PathParam("id") long id) {
        return Response.ok(fileRepository.findById(id)).build();
    }

    @DELETE
    @Path("{id}")
    @RolesAllowed("TEACHER")
    public Response delete(@PathParam("id") Long id) {
        try {
            fileRepository.deleteById(id);
            return Response
                    .ok()
                    .build();
        } catch (IllegalArgumentException e) {
            return Response
                    .status(400)
                    .header("Reason", "File with id" + id + "does not exist")
                    .build();
        }
    }
}
