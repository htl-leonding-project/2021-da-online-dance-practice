package at.htl.boundary;

import at.htl.control.LevelRepository;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.Path;

@RequestScoped
@Path("/Level")
public class LevelEndpoint {

    @Inject
    LevelRepository levelRepository;
}
