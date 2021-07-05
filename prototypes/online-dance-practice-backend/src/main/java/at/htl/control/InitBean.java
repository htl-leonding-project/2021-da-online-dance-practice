package at.htl.control;

import at.htl.entity.Content;
import at.htl.entity.Course;
import at.htl.entity.Level;
import at.htl.entity.User;
import io.quarkus.runtime.StartupEvent;

import javax.enterprise.event.Observes;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

public class InitBean {

    @Inject
    CourseRepository courseRepository;

    @Inject
    UserRepository userRepository;

    @Transactional
    void onStart(@Observes StartupEvent event) {
        initDb();
    }

    private void initDb() {

        User samuel = new User();
        userRepository.persist(samuel);
        User anna = new User();
        userRepository.persist(anna);
        User max = new User();
        userRepository.persist(max);
        User julia = new User();
        userRepository.persist(julia);


        List<Content> contents = new ArrayList<Content>();
        contents.add( Content.valueOf("VIDEO"));
        contents.add( Content.valueOf("VIDEO"));
        contents.add( Content.valueOf("VIDEO"));

        Course latein = new Course("Langsamer Walzer",contents, Level.valueOf("GRUNDKURS"));
        courseRepository.persist(latein);

    }

}
