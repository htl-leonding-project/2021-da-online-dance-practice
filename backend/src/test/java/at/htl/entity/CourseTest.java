package at.htl.entity;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import javax.transaction.Transactional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@QuarkusTest
class CourseTest {


    @Order(10)
    @Test
    @Transactional
    public void create(){


        Level level = new Level("Bronze","1. Level");
        level.persist();
        Course course = new Course("Latino für Anfänger","Latino für Anfänger",level);
        course.persist();
    }

    @Order(20)
    @Test
    @Transactional
    public void CourseToString(){
        Level level = new Level("Bronze","1. Level");
        level.persist();
        Course course = new Course("Sambo für Anfänger","Sambo für Anfänger",level);
        course.persist();

        System.out.println(course);

        assertThat(course.toString()).isEqualTo("Course{courseId=1, title='Sambo für Anfänger', descr='Sambo für Anfänger', level=Level{levelId='Bronze', description='1. Level'}}");

    }

}