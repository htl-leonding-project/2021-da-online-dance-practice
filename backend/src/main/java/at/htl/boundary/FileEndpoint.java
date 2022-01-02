package at.htl.boundary;

import at.htl.control.CourseRepository;
import at.htl.control.FileRepository;
import at.htl.control.UsageRepository;
import at.htl.entity.ContentType;
import at.htl.entity.D_File;
import org.apache.commons.io.IOUtils;
import org.jboss.logging.Logger;
import org.jboss.resteasy.annotations.providers.multipart.MultipartForm;
import org.jboss.resteasy.plugins.providers.multipart.InputPart;
import org.jboss.resteasy.plugins.providers.multipart.MultipartFormDataInput;


import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.servlet.ServletContext;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.*;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;


@RequestScoped
@Path("/file")
public class FileEndpoint {

    @Inject
    FileRepository fileRepository;

    @Inject
    UsageRepository usageRepository;

    @Inject
    CourseRepository courseRepository;

    private final String UPLOADED_FILE_PATH = "/opt/upload/";

    @Context
    private ServletContext context;


    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response findall() {
        return Response.ok(fileRepository.listAll()).build();
        /*JsonObject hello = Json.createObjectBuilder().add("name", "sandy").build();
        return Response.ok(hello).build();*/
    }

    /**
     * https://mkyong.com/webservices/jax-rs/file-upload-example-in-resteasy/
     */
    @POST
    @Path("/upload")
    @Consumes(MediaType.MULTIPART_FORM_DATA)
    public Response uploadFile(MultipartFormDataInput input) throws IOException {

        String fileName = "";

        Map<String, List<InputPart>> uploadForm = input.getFormDataMap();
        List<InputPart> inputParts = uploadForm.get("uploadedFile");

        for (InputPart inputPart : inputParts) {

            try {

                MultivaluedMap<String, String> header = inputPart.getHeaders();
                fileName = getFileName(header);

                //convert the uploaded file to inputstream
                InputStream inputStream = inputPart.getBody(InputStream.class, null);

                byte[] bytes = IOUtils.toByteArray(inputStream);

                //constructs upload file path
                fileName = UPLOADED_FILE_PATH + fileName;

                writeFile(bytes, fileName);

                System.out.println("Done");

            } catch (IOException e) {
                e.printStackTrace();
            }

        }

        return Response.status(200)
                .entity("Hochladen von " + fileName + " war erfolgreich")
                .header("Access-Control-Allow-Origin", "*")
                .header("Access-Control-Allow-Headers", "accept, origin, authorization, content-type, x-requested-with")
                .header("Access-Control-Allow-Methods", "GET,POST,OPTIONS,DELETE,PATCH,PUT")
                .header("Access-Control-Allow-Headers", "origin,x-requested-with,content-type,Accept, x-client-key, x-client-token, x-client-secret, Authorization")
                .build();

    }



//    /**
//     * Quelle: https://stackoverflow.com/a/62134245
//     *
//     * @param upload
//     * @return
//     * @throws IOException
//     */
//    @POST
//    @Path("/upload")
//    @Consumes(MediaType.MULTIPART_FORM_DATA)
//    public Response uploadFile(@MultipartForm FormData upload) throws IOException {
//        LOG.infof("File path: %s", upload.file.getAbsolutePath());
//        return Response.ok().build();
//    }

    private String getFileName(MultivaluedMap<String, String> header) {
        String finalFileName;

        String[] contentDisposition = header.getFirst("Content-Disposition").split(";");

        for (String filename : contentDisposition) {
            if ((filename.trim().startsWith("filename"))) {

                String[] name = filename.split("=");

                finalFileName = name[1].trim().replaceAll("\"", "");
                return finalFileName;
            }
        }

        return "unknown";
    }

    //save to somewhere
    private void writeFile(byte[] content, String filePath) throws IOException {
        File file = new File(filePath);

        if (!file.exists()) {
            file.createNewFile();
        }

        FileOutputStream fop = new FileOutputStream(file);

        fop.write(content);

        String[] fileTypeArray = filePath.split("\\.");
        String[] parts = filePath.split("/");
        String filename = parts[parts.length - 1];
        System.out.println("filePath " + filePath);

        if (fileTypeArray[1].equals("mp4") || fileTypeArray[1].equals("mov")) {
            D_File file1 = new D_File(filename, file.getPath(), "", ContentType.VIDEO);
            fileRepository.persist(file1);
        } else if (fileTypeArray[1].equals("mp3")) {
            D_File file1 = new D_File(filename, file.getPath(), "", ContentType.AUDIO);
            fileRepository.persist(file1);
        }

        fop.flush();
        fop.close();
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
                    .header("Reason", "File with id" + id + "does not exist")
                    .build();
        }
    }


}
