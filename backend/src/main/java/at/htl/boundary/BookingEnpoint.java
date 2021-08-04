package at.htl.boundary;

import at.htl.control.BookingRepository;
import at.htl.entity.Booking;

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
@Path("/")
public class BookingEnpoint {

    @Inject
    BookingRepository bookingRepository;

    @GET
    @Path("/findAll")
    @Produces(MediaType.APPLICATION_JSON)
    public Response findAll() {
        return Response.ok(bookingRepository.findAll()).build();
    }


    @POST
    @Path("/create")
    @Transactional
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response create(Booking booking, @Context UriInfo info) {
        bookingRepository.persist(booking);
        return Response.created(URI.create(info.getPath() + "/"+ booking.bookingId)).build();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response findById(@PathParam("id") long id) {
        return Response.ok( bookingRepository.findById(id)).build();
    }


    @DELETE
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Transactional
    public Response delete(@PathParam("id") Long id) {
        try {
            bookingRepository.deleteById(id);
            return Response
                    .noContent()
                    .build();
        } catch (IllegalArgumentException e) {
            return Response
                    .status(400)
                    .header("Reason","Booking with id" +id  + "does not exist")
                    .build();
        }
    }

}
