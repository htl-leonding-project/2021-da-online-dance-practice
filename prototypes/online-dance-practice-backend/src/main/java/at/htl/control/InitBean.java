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

    @Inject
    CourseRepository courseRepository;

    void onStart(@Observes StartupEvent event) {
        initDb();
    }

    @Transactional
    void initDb() {

        Level grundkurs = new Level("1","GRUNDKURS");
        levelRepository.persist(grundkurs);
        Level bronze = new Level("2","BRONZE");
        levelRepository.persist(bronze);
        Level silber = new Level("3","SILBER");
        levelRepository.persist(silber);
        Level gold = new Level("4","GOLD");
        levelRepository.persist(gold);
        Level goldstar = new Level("5","GOLDSTAR");
        levelRepository.persist(goldstar);
        Level topclass = new Level("6","TOPCLASS");
        levelRepository.persist(topclass);

        //User
        User kelly = new User("KellyTran03","Kelly", "Tran ");
        userRepository.persist(kelly);
        User rosalie = new User("RosalieMandel14","Rosalie", "Mandel ");
        userRepository.persist(rosalie);
        User sandy = new User("SandyTang24","Sandy", "Tang ");
        userRepository.persist(sandy);
        User anton = new User("Anton123","Anton", "Traxler");
        userRepository.persist(anton);
        User lisa = new User("Lisa124","Lisa", "Müller ");
        userRepository.persist(lisa);
        User jonas = new User("JonasT123","Jonas", "Berg ");
        userRepository.persist(jonas);






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
