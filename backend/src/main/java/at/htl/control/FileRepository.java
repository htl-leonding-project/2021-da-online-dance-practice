package at.htl.control;

import at.htl.entity.Course;
import at.htl.entity.D_File;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

import javax.enterprise.context.ApplicationScoped;
import java.util.List;

@ApplicationScoped
public class FileRepository implements PanacheRepository<D_File> {

    public List<D_File> findFilesByCourse(Course course) {
        return find("course", course).list();
    }
}
