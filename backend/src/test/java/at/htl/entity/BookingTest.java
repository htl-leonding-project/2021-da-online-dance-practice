package at.htl.entity;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import javax.transaction.Transactional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@QuarkusTest
class BookingTest {

    @Order(10)
    @Test
    @Transactional
    public void create() {


        User samuel = new User("samu123","Samuel","Haus");
        samuel.persist();

        Level level = new Level("Gold","1. Level");
        level.persist();
        Course course = new Course("Latino für Anfänger","Latino für Anfänger",level);
        course.persist();


        Booking booking = new Booking(samuel,course);
        booking.persist();

    }

    @Order(20)
    @Test
    @Transactional
    public void bookingToString() {
        User samuel = new User("samu123","Samuel","Haus");
        samuel.persist();

        Level level = new Level("Grundkurs","1. Level");
        level.persist();
        Course course = new Course("Latino für Anfänger","Latino für Anfänger",level);
        course.persist();

        Booking booking = new Booking(samuel,course);
        booking.persist();

        System.out.println(booking);

        assertThat(booking.toString()).isEqualTo("Booking{id=6, user=User{id=8, username='samu123', firstname='Samuel', lastname='Haus'}, course=Course{id=6, title='Latino für Anfänger', descr='Latino für Anfänger', level=Level{id='Grundkurs', description='1. Level'}}}");

    }

}
