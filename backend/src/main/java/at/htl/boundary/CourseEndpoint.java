package at.htl.boundary;

import at.htl.control.CourseRepository;
import at.htl.control.LevelRepository;
import at.htl.control.UsageRepository;
import at.htl.entity.Course;
import at.htl.entity.D_File;
import at.htl.entity.Level;

import javax.annotation.security.RolesAllowed;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import java.net.URI;
import java.util.List;

@RequestScoped
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Path("/course")
public class CourseEndpoint {

    @Inject
    CourseRepository courseRepository;

    @Inject
    LevelRepository levelRepository;

    @Inject
    UsageRepository usageRepository;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @RolesAllowed({"STUDENT", "TEACHER"})
    public Response findAll() {
        return Response.ok(courseRepository.listAll()).build();
    }

    @POST
    @Path("/create")
    @RolesAllowed("TEACHER")
    public Response create(String levelId, @Context UriInfo info, String title, String description) {
        Level level = levelRepository.findById(levelId);
        Course course = new Course(title, description, level);

        courseRepository.persist(course);

        return Response
                .created(URI.create(info.getPath() + "/" + course.id))
                .build();
    }

    @GET
    @Path("/{id}")
    @RolesAllowed({"STUDENT", "TEACHER"})
    public Response findById(@PathParam("id") long id) {
        return Response.ok(courseRepository.findById(id)).build();
    }

//    @DELETE
//    @Path("/{title}")
//    @Produces(MediaType.APPLICATION_JSON)
//    @Consumes(MediaType.APPLICATION_JSON)
//    @Transactional
//    public Response delete(@PathParam("title") String title) {
//
//        Course course = courseRepository.find("title", title)
//                .stream()
//                .findFirst()
//                .orElse(null);
//
//        if (course != null) {
//            courseRepository.delete("title", course.title);
//            return Response.ok().build();
//        } else {
//            return Response.status(Response.Status.NOT_FOUND).build();
//        }
//       /* try {
//            courseRepository.delete(title);
//            return Response
//                    .noContent()
//                    .build();
//        } catch (IllegalArgumentException e) {
//            return Response
//                    .status(400)
//                    .header("Reason", "Course with id" + title + "does not exist")
//                    .build();
//        }*/
//    }

    @DELETE
    @Path("/{id}")
    @RolesAllowed("TEACHER")
    public Response delete(@PathParam("id") Long id) {
        try {
            courseRepository.deleteById(id);
            return Response
                    .noContent()
                    .build();
        } catch (IllegalArgumentException e) {
            return Response
                    .status(Response.Status.BAD_REQUEST)
                    .header("Reason", "Course with id " + id + " does not exist")
                    .build();
        }
    }


    @GET
    @Path("/findByLevel/{levelId}")
    @RolesAllowed({"STUDENT", "TEACHER"})
    public Response findCourseByLevel(@PathParam("levelId") String levelId) {
        Level level = new Level(levelId.toUpperCase(), levelId.toUpperCase());
        return Response.ok().entity(courseRepository.findCourseByLevel(level)).build();
    }


    @GET
    @Path("/filesByCourse/{courseId}")
    @RolesAllowed({"STUDENT", "TEACHER"})
    public Response findMediaFileByCourse(@PathParam("courseId") long courseId) {
        List<D_File> files = usageRepository.findFilesByCourseId(courseId);
        return Response
                .ok(files)
                .build();
    }




}
