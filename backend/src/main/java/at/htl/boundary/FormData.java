package at.htl.boundary;

import javax.ws.rs.FormParam;
import java.io.File;

public class FormData {

    @FormParam("uploadedFile")
    //@PartType(MediaType.APPLICATION_OCTET_STREAM)
    public File file;

//    @FormParam("fileName")
//    @PartType(MediaType.TEXT_PLAIN)
//    public String fileName;

}
