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

        List<Content> contentsForLatein = new ArrayList<Content>();
        contentsForLatein.add( Content.valueOf("VIDEO"));
        contentsForLatein.add( Content.valueOf("AUDIO"));
        contentsForLatein.add( Content.valueOf("VIDEO"));
        contentsForLatein.add( Content.valueOf("VIDEO"));
        Course latein = new Course("Langsamer Walzer",contentsForLatein, Level.valueOf("GRUNDKURS"));
        courseRepository.persist(latein);

        List<Content> contentsForStandard = new ArrayList<Content>();
        contentsForStandard.add( Content.valueOf("VIDEO"));
        contentsForStandard.add( Content.valueOf("AUDIO"));
        contentsForStandard.add( Content.valueOf("AUDIO"));
        contentsForStandard.add( Content.valueOf("AUDIO"));
        Course standard = new Course("Langsamer Walzer",contentsForStandard, Level.valueOf("SILBER"));
        courseRepository.persist(standard);

        List<Content> contentsForLatino = new ArrayList<Content>();
        contentsForLatino.add( Content.valueOf("VIDEO"));
        contentsForLatino.add( Content.valueOf("AUDIO"));
        contentsForLatino.add( Content.valueOf("VIDEO"));
        contentsForLatino.add( Content.valueOf("VIDEO"));
        Course latino = new Course("Langsamer Walzer",contentsForLatino, Level.valueOf("BRONZE"));
        courseRepository.persist(latino);
    }

}
