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

    @Inject
    UserRepository userRepository;

    void onStart(@Observes StartupEvent event) {
        initDb();
    }

    @Transactional
    void initDb() {

        Level grundkurs = new Level("GRUNDKURS");
        levelRepository.persist(grundkurs);
        Level bronze = new Level("BRONZE");
        levelRepository.persist(bronze);
        Level silber = new Level("SILBER");
        levelRepository.persist(silber);
        Level gold = new Level("GOLD");
        levelRepository.persist(gold);
        Level goldstar = new Level("GOLDSTAR");
        levelRepository.persist(goldstar);
        Level topclass = new Level("TOPCLASS");
        levelRepository.persist(topclass);




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
