package at.htl.boundary;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.Path;

@RequestScoped
@Path("/consumation")
public class UserEndpoint {

    @Inject
    UserEndpoint userEndpoint;

}
