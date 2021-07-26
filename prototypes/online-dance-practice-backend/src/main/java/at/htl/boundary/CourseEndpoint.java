package at.htl.boundary;

import at.htl.control.CourseRepository;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@RequestScoped
@Path("/course")
public class CourseEndpoint {

    @Inject
    CourseRepository courseRepository;


}
