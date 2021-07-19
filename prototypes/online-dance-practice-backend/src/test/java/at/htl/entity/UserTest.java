package at.htl.entity;


import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;

@QuarkusTest
class UserTest {


    @Order(10)
    @Test
    public void createUser_Test(){

        User samuel = new User();



    }

}
