package at.htl.control;

import at.htl.entity.File;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class FileRepository implements PanacheRepository<File> {

}
