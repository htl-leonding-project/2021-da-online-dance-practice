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


}
