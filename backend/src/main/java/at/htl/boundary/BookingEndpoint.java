package at.htl.boundary;

import at.htl.control.BookingRepository;
import at.htl.control.CourseRepository;
import at.htl.control.UserRepository;
import at.htl.entity.Booking;
import at.htl.entity.Course;
import at.htl.entity.User;

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
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Path("/booking")
public class BookingEndpoint {

    @Inject
    BookingRepository bookingRepository;

    @Inject
    CourseRepository courseRepository;

    @Inject
    UserRepository userRepository;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response findAll() {
        return Response.ok(bookingRepository.listAll()).build();
    }

    @POST
    @Path("/create/{courseId}/{userId}")
    public Response create(@PathParam("courseId") long courseId,
                           @PathParam("userId") long userId,
                           @Context UriInfo info) {
        Course course = courseRepository.findById(courseId);
        User user = userRepository.findById(userId);

        Booking booking = new Booking(user, course);
        bookingRepository.persist(booking);

        return Response
                .created(URI.create(info.getPath() + "/" + booking.id))
                .build();
    }


    @GET
    @Path("/{id}")
    public Response findById(@PathParam("id") long id) {
        return Response.ok(bookingRepository.findById(id)).build();
    }


    @DELETE
    @Path("/{id}")
    public Response delete(@PathParam("id") Long id) {
        try {
            bookingRepository.deleteById(id);
            return Response
                    .noContent()
                    .build();
        } catch (IllegalArgumentException e) {
            return Response
                    .status(Response.Status.BAD_REQUEST)
                    .header("Reason", "Booking with id " + id + " does not exist")
                    .build();
        }
    }
}
