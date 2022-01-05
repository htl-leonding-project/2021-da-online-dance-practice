package at.htl.control;

import at.htl.entity.*;
import io.quarkus.runtime.StartupEvent;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Observes;
import javax.inject.Inject;
import javax.transaction.Transactional;

@ApplicationScoped
public class InitBean {

    @Inject
    LevelRepository levelRepository;

    @Inject
    UserRepository userRepository;

    @Inject
    CourseRepository courseRepository;

    @Inject
    BookingRepository bookingRepository;

    @Inject
    FileRepository fileRepository;

    @Inject
    UsageRepository usageRepository;

    void onStart(@Observes StartupEvent event) {
        initDb();
    }

    @Transactional
    void initDb() {

        //Level
        Level grundkurs = new Level("GRUNDKURS", "GRUNDKURS");
        levelRepository.persist(grundkurs);
        Level bronze = new Level("BRONZE", "BRONZE");
        levelRepository.persist(bronze);
        Level silber = new Level("SILBER", "SILBER");
        levelRepository.persist(silber);
        Level gold = new Level("GOLD", "GOLD");
        levelRepository.persist(gold);
        Level goldstar = new Level("GOLDSTAR", "GOLDSTAR");
        levelRepository.persist(goldstar);
        Level topclass = new Level("TOPCLASS", "TOPCLASS");
        levelRepository.persist(topclass);

        //User
        User kelly = new User("KellyTran03", "Kelly", "Tran", "12324", Role.STUDENT);
        userRepository.persist(kelly);
        User rosalie = new User("RosalieMandel14", "Rosalie", "Mandel ", "456", Role.STUDENT);
        userRepository.persist(rosalie);
        User sandy = new User("SandyTang24", "Sandy", "Tang ", "sandypw", Role.TEACHER);
        userRepository.persist(sandy);
        User anton = new User("Anton123", "Anton", "Traxler", "akdjb", Role.TEACHER);
        userRepository.persist(anton);
        User lisa = new User("Lisa124", "Lisa", "Müller ", "<jnov", Role.STUDENT);
        userRepository.persist(lisa);
        User jonas = new User("JonasT123", "Jonas", "Berg ", "orslgn", Role.TEACHER);
        userRepository.persist(jonas);

        //Course
        Course discofox = new Course("Grundschritte & Figuren", "Für alle Gelengheiten", grundkurs);
        courseRepository.persist(discofox);
        Course westcoastswing = new Course("Der internationale Trend ", "Sehr cool!", grundkurs);
        courseRepository.persist(westcoastswing);
        Course tanzclubs = new Course("Plus Ballroom & Slowfox", "In Ried, Regau ubd Wels", grundkurs);
        courseRepository.persist(tanzclubs);
        Course pirvatstunden = new Course("Individuell buchbar", "Termin vereinbaren!", grundkurs);
        courseRepository.persist(pirvatstunden);

        //Booking
        Booking booking01 = new Booking(kelly, discofox);
        bookingRepository.persist(booking01);
        Booking booking02 = new Booking(rosalie, westcoastswing);
        bookingRepository.persist(booking02);
        Booking booking03 = new Booking(sandy, tanzclubs);
        bookingRepository.persist(booking03);
        Booking booking04 = new Booking(anton, pirvatstunden);
        bookingRepository.persist(booking04);

        //File
        //audio
        D_File senorita = new D_File("01_CHA-Senorita(original).mp3", "mediafiles/audio", "description", ContentType.valueOf("AUDIO"));
        fileRepository.persist(senorita);
        D_File ice = new D_File("03_LikeIceinthesunshine.mp3", "mediafiles/audio", "description", ContentType.valueOf("AUDIO"));
        fileRepository.persist(ice);
        D_File coupe = new D_File("04_CoupedeVille.mp3", "mediafiles/audio", "description", ContentType.valueOf("AUDIO"));
        fileRepository.persist(coupe);
        D_File california = new D_File("05_HotelCalifornia-DJRoy-(LatinGoodVibration2)-AO-WM,EN.mp3", "mediafiles/audio", "description", ContentType.valueOf("AUDIO"));
        fileRepository.persist(california);
        D_File wonder = new D_File("06_lwonderwhy-03-slow-waltz.wav", "mediafiles/audio", "description", ContentType.valueOf("AUDIO"));
        fileRepository.persist(wonder);
        D_File promises = new D_File("07-Promises-TanzorchesterKlausHallen-(ChartbreakerVol. 21)-ZL- PP,EN.mp3", "mediafiles/audio", "description", ContentType.valueOf("AUDIO"));
        fileRepository.persist(promises);
        D_File fading = new D_File("08-Fading-TanzorchesterKlausHallen-(ChartbreakerVol.21)-ZL-PP,EN.mp3", "mediafiles/audio", "description", ContentType.valueOf("AUDIO"));
        fileRepository.persist(california);
        D_File bachataDeja = new D_File("09Bachata-Dejavu.mp3", "mediafiles/audio", "description", ContentType.valueOf("AUDIO"));
        fileRepository.persist(bachataDeja);
        D_File sal = new D_File("10_SAL-Feliceslos4(SalsaVersio.mp3", "mediafiles/audio", "description", ContentType.valueOf("AUDIO"));
        fileRepository.persist(sal);
        D_File havana = new D_File("11-31-Havana-DJBernat-(LatinMusic14)-Casaphon-PP,EN.mp3", "mediafiles/audio", "description", ContentType.valueOf("AUDIO"));
        fileRepository.persist(havana);
        D_File mama = new D_File("12-51-Mama-DJRicoLatino-(LatinMusic14)-Casaphon-PP,EN.mp3", "mediafiles/audio", "description", ContentType.valueOf("AUDIO"));
        fileRepository.persist(mama);
        D_File sweet = new D_File("13SweetButPsycho-TanzorchesterKlausHallen-(ChartbreakerVol.21)-ZL-PP,EN.mp3", "mediafiles/audio", "description", ContentType.valueOf("AUDIO"));
        fileRepository.persist(sweet);
        D_File tango = new D_File("14_TangoPorUnaCabeza-instrumentalviolincover-stringquartet.mp3", "mediafiles/audio", "description", ContentType.valueOf("AUDIO"));
        fileRepository.persist(tango);
        D_File lieblingmensch = new D_File("15-29-Lieblingsmensch-Lila-(BallroomNights8)-Casaphon-PP,DE.mp3", "mediafiles/audio", "description", ContentType.valueOf("AUDIO"));
        fileRepository.persist(lieblingmensch);
        D_File roses = new D_File("16_WW-RosesFromTheSouth.mp3", "mediafiles/audio", "description", ContentType.valueOf("AUDIO"));
        fileRepository.persist(roses);
        D_File paso = new D_File("17-PASO-Manolita60.mp3", "mediafiles/audio", "description", ContentType.valueOf("AUDIO"));
        fileRepository.persist(paso);
        D_File aldo = new D_File("18-AldoCapioccioni-05-MyWay-SW28.wav", "mediafiles/audio", "description", ContentType.valueOf("AUDIO"));
        fileRepository.persist(aldo);
        D_File tuesday = new D_File("19-Tuesday(feat.DanelleSandoval).mp3", "mediafiles/audio", "description", ContentType.valueOf("AUDIO"));
        fileRepository.persist(tuesday);
        D_File dancelife = new D_File("20-IStillHaven'tFound(shortversion)-DancelifeStudioOrchestra-(Bring16smilestoyoufeet)-Dancelife-LP,SP.mp3", "mediafiles/audio", "description", ContentType.valueOf("AUDIO"));
        fileRepository.persist(dancelife);
        D_File bailando = new D_File("21_SAL-Bailando(feat.DescemerBu.mp3", "mediafiles/audio", "description", ContentType.valueOf("AUDIO"));
        fileRepository.persist(bailando);
        D_File ready = new D_File("22_I'mReady.mp3", "mediafiles/audio", "description", ContentType.valueOf("AUDIO"));
        fileRepository.persist(ready);
        D_File df = new D_File("23_DF-Warumhastdunichtneinges.mp3", "mediafiles/audio", "description", ContentType.valueOf("AUDIO"));
        fileRepository.persist(df);
        D_File ex = new D_File("24-50-Ex'sAndOh's-Swingpop!-(BallroomNights8)-Casaphon-SW,EN.mp3", "mediafiles/audio", "description", ContentType.valueOf("AUDIO"));
        fileRepository.persist(ex);
        D_File hold = new D_File("25-29-HoldMyGirl-TanzorchesterKlausHallen-(ChartbreakerVol.21)-ZL-PP,EN.mp3", "mediafiles/audio", "description", ContentType.valueOf("AUDIO"));
        fileRepository.persist(hold);
        D_File sed = new D_File("26_SeddeTi...DustinRichie...(bachatanew2019)(audio).mp3", "mediafiles/audio", "description", ContentType.valueOf("AUDIO"));
        fileRepository.persist(sed);
        D_File bang = new D_File("27-BangBang,Part2-Genio&Pierrots-(LatinMegaHits6)-CM-IT,PP.mp3", "mediafiles/audio", "description", ContentType.valueOf("AUDIO"));
        fileRepository.persist(bang);

        D_File bachata = new D_File("Bachata-OnlineTanzkurs.mov", "mediafiles/video", "description", ContentType.valueOf("VIDEO"));
        fileRepository.persist(bachata);
/*        D_File hiphop = new D_File("HipHopBartSimpson.mov", "mediafiles/video","description", ContentType.valueOf("VIDEO"));
        fileRepository.persist(hiphop);*/
        D_File file02 = new D_File("File02", "/cdb", "description", ContentType.valueOf("VIDEO"));
        fileRepository.persist(file02);
        D_File file03 = new D_File("File03", "/bdc", "description", ContentType.valueOf("AUDIO"));
        fileRepository.persist(file03);
        D_File file04 = new D_File("File04", "/gfh", "description", ContentType.valueOf("VIDEO"));
        fileRepository.persist(file04);
        D_File file05 = new D_File("File05", "/gfh", "description", ContentType.valueOf("AUDIO"));
        fileRepository.persist(file05);

        D_File salsa = new D_File("SalsaChrisFigurdesMonats.mp4", "mediafiles/video", "description", ContentType.valueOf("VIDEO"));
        fileRepository.persist(salsa);
        D_File wienerwalz = new D_File("WienerWalzer.mov", "mediafiles/video", "description", ContentType.valueOf("VIDEO"));
        fileRepository.persist(wienerwalz);
        D_File hiphop = new D_File("HipHopBartSimpson.mov", "mediafiles/video", "description", ContentType.valueOf("VIDEO"));
        fileRepository.persist(hiphop);

        //Usage
        Usage usage01 = new Usage(discofox, salsa);
        usageRepository.persist(usage01);
        Usage usage02 = new Usage(westcoastswing, sed);
        usageRepository.persist(usage02);
        Usage usage03 = new Usage(tanzclubs, mama);
        usageRepository.persist(usage03);
        Usage usage04 = new Usage(pirvatstunden, dancelife);
        usageRepository.persist(usage04);
        Usage usage05 = new Usage(discofox, wienerwalz);
        usageRepository.persist(usage05);
/*        Usage usage06 = new Usage(discofox,hiphop);
        usageRepository.persist(usage06);*/
        Usage usage07 = new Usage(discofox, roses);
        usageRepository.persist(usage07);
        Usage usage08 = new Usage(discofox, wonder);
        usageRepository.persist(usage08);
        Usage usage09 = new Usage(discofox, hiphop);
        usageRepository.persist(usage09);
        Usage usage10 = new Usage(westcoastswing, bang);
        usageRepository.persist(usage10);
        Usage usage11 = new Usage(westcoastswing, hold);
        usageRepository.persist(usage11);
        Usage usage12 = new Usage(tanzclubs, dancelife);
        usageRepository.persist(usage12);
        Usage usage13 = new Usage(tanzclubs, roses);
        usageRepository.persist(usage13);
        Usage usage14 = new Usage(pirvatstunden, hold);
        usageRepository.persist(usage14);
        Usage usage15 = new Usage(pirvatstunden, tango);
        usageRepository.persist(usage15);
    }
}
