package at.htl.entity;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import javax.transaction.Transactional;

import static org.assertj.core.api.Assertions.assertThat;

@QuarkusTest
class UsageTest {


    @Order(10)
    @Test
    @Transactional
    public void create() {

        D_File file = new D_File("Hipopvideo Example", "/assets/HipopvideoExample.mp4", ContentType.VIDEO);
        file.persist();
        Level level = new Level("Goldstar", "5. Level");
        level.persist();
        Course course = new Course("Latino für Anfänger", "Latino für Anfänger", level);
        course.persist();

        Usage usage = new Usage(course, file);
        usage.persist();

    }

    @Order(20)
    @Test
    @Transactional
    public void usageToString() {
        D_File file = new D_File("Hipopvideo Example", "/assets/HipopvideoExample.mp4", ContentType.VIDEO);
        file.persist();
        Level level = new Level("Topclass", "6. Level");
        level.persist();
        Course course = new Course("Latino für Anfänger", "Latino für Anfänger", level);
        course.persist();

        Usage usage = new Usage(course, file);
        usage.persist();
        System.out.println(usage);

        assertThat(usage.toString()).isEqualTo("Usage{id=4, course=Course{id=10, title='Latino für Anfänger', descr='Latino für Anfänger', level=Level{id='Topclass', description='6. Level'}}, file=File{id=35, name='Hipopvideo Example', path='/assets/HipopvideoExample.mp4', contentType=VIDEO}}");

    }
}
