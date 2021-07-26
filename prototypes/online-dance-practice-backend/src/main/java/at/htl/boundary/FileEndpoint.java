package at.htl.boundary;

import at.htl.control.CourseRepository;
import at.htl.control.FileRepository;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.Path;

@RequestScoped
@Path("/File")
public class FileEndpoint {

    @Inject
    FileRepository fileRepository;

}
