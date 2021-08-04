package at.htl.boundary;

import at.htl.control.CourseRepository;
import at.htl.entity.Course;
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
import java.util.List;

@RequestScoped
@Path("/course")
public class CourseEndpoint {

    @Inject
    CourseRepository courseRepository;

    @GET
    @Path("/findAll")
    @Produces(MediaType.APPLICATION_JSON)
    public Response findAll() {
        return Response.ok(courseRepository.findAll()).build();
    }

    @POST
    @Path("/create")
    @Transactional
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response create(Course course, @Context UriInfo info) {
        courseRepository.persist(course);
        return Response.created(URI.create(info.getPath() + "/"+ course.courseId)).build();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response findById(@PathParam("id") long id) {
        return Response.ok(courseRepository.findById(id)).build();
    }

    @DELETE
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Transactional
    public Response delete(@PathParam("id") Long id) {
        try {
            courseRepository.deleteById(id);
            return Response
                    .noContent()
                    .build();
        } catch (IllegalArgumentException e) {
            return Response
                    .status(400)
                    .header("Reason","Course with id" +id  + "does not exist")
                    .build();
        }
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response findCourseByLevel(Level level) {
        return Response.ok().entity(courseRepository.findCourseByLevel(level)).build();
    }
}
