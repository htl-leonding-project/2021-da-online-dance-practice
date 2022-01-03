package at.htl.control;

import at.htl.entity.Course;
import at.htl.entity.D_File;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import javax.ws.rs.FormParam;
import java.io.File;
import java.util.List;

@ApplicationScoped
@Transactional
public class FileRepository implements PanacheRepository<D_File> {

    @Inject
    EntityManager em;

    @FormParam("uploadedFile")
    public File file;

    public List<D_File> findFilesByCourse(Course course) {
        return find("course", course).list();
    }


}
