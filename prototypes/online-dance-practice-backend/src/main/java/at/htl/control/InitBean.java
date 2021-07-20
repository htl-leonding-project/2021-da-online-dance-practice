package at.htl.control;

import at.htl.entity.ContentType;
import at.htl.entity.Course;
import at.htl.entity.Level;
import at.htl.entity.User;
import io.quarkus.runtime.StartupEvent;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Observes;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
public class InitBean {

    @Inject
    LevelRepository levelRepository;

    void onStart(@Observes StartupEvent event) {
        initDb();
    }

    @Transactional
    void initDb() {

        levelRepository.persist(new Level("GRUNDKURS"));
        levelRepository.persist(new Level("BRONZE"));
        levelRepository.persist(new Level("SILBER"));
        levelRepository.persist(new Level("GOLD"));
        levelRepository.persist(new Level("GOLDSTAR"));
        levelRepository.persist(new Level("TOPCLASS"));
        //User
//        User samuel = new User();
//        userRepository.persist(samuel);
//        User anna = new User();
//        userRepository.persist(anna);
//        User max = new User();
//        userRepository.persist(max);
//        User julia = new User();
//        userRepository.persist(julia);
//        User lena = new User();
//        userRepository.persist(lena);
//        User sebastian = new User();
//        userRepository.persist(sebastian);
//        User manuel = new User();
//        userRepository.persist(manuel);
//        User david = new User();
//        userRepository.persist(david);
//        User eva = new User();
//        userRepository.persist(eva);
//        User marie = new User();
//        userRepository.persist(marie);

        //Courses
//        List<ContentType> contentsForLatein = new ArrayList<ContentType>();
//        contentsForLatein.add( ContentType.valueOf("VIDEO"));
//        contentsForLatein.add( ContentType.valueOf("AUDIO"));
//        contentsForLatein.add( ContentType.valueOf("VIDEO"));
//        contentsForLatein.add( ContentType.valueOf("VIDEO"));
//        Course latein = new Course("Langsamer Walzer",contentsForLatein, Level.valueOf("GRUNDKURS"));
//        courseRepository.persist(latein);
//
//        List<ContentType> contentsForStandard = new ArrayList<ContentType>();
//        contentsForStandard.add( ContentType.valueOf("VIDEO"));
//        contentsForStandard.add( ContentType.valueOf("AUDIO"));
//        contentsForStandard.add( ContentType.valueOf("AUDIO"));
//        contentsForStandard.add( ContentType.valueOf("AUDIO"));
//        Course standard = new Course("Wiener Walzer",contentsForStandard, Level.valueOf("SILBER"));
//        courseRepository.persist(standard);
//
//        List<ContentType> contentsForLatino = new ArrayList<ContentType>();
//        contentsForLatino.add( ContentType.valueOf("VIDEO"));
//        contentsForLatino.add( ContentType.valueOf("AUDIO"));
//        contentsForLatino.add( ContentType.valueOf("VIDEO"));
//        contentsForLatino.add( ContentType.valueOf("VIDEO"));
//        Course latino = new Course("Slow Fox",contentsForLatino, Level.valueOf("BRONZE"));
//        courseRepository.persist(latino);

    }

}
