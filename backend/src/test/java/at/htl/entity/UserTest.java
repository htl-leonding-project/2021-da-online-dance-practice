package at.htl.entity;


import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;


import javax.transaction.Transactional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@QuarkusTest
class UserTest {



    @Order(10)
    @Test
    @Transactional
    public void create() {


        User user = new User("rosi1234", "Rosalie", "Mandel");
        user.persist();

    }

    @Order(20)
    @Test
    @Transactional
    public void userToString() {
        User user = new User("rosi1234", "Rosalie", "Mandel");
        user.persist();

        System.out.println(user);

        assertThat(user.toString()).isEqualTo("User{userId=8, username='rosi1234', firstname='Rosalie', lastname='Mandel'}");

    }
}
