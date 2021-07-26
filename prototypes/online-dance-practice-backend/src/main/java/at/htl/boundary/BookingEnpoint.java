package at.htl.boundary;

import at.htl.control.BookingRepository;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.Path;

@RequestScoped
@Path("/")
public class BookingEnpoint {

    @Inject
    BookingRepository bookingRepository;
}
