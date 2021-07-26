package at.htl.boundary;

import at.htl.control.UsageRepository;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.Path;

@RequestScoped
@Path("/Usage")
public class UsageEndpoint {

    @Inject
    UsageRepository usageRepository;

}
