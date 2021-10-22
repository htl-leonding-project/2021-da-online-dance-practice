package at.htl.entity;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import javax.transaction.Transactional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@QuarkusTest
class LevelTest {


    @Order(10)
    @Test
    @Transactional
    public void create() {


        Level level = new Level("Bronze", "1. Level");
        level.persist();

    }

    @Order(20)
    @Test
    @Transactional
    public void LevelToString() {
        Level level = new Level("Silber", "2. Level");
        level.persist();


        System.out.println(level);

        assertThat(level.toString()).isEqualTo("Level{id='Silber', description='2. Level'}");

    }


}
