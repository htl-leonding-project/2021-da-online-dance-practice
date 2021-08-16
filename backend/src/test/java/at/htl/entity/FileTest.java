package at.htl.entity;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import javax.transaction.Transactional;

import static org.assertj.core.api.Assertions.assertThat;

@QuarkusTest
class FileTest {

    @Order(10)
    @Test
    @Transactional
    public void create(){

        D_File file = new D_File("Hipopvideo Example","/assets/HipopvideoExample.mp4",ContentType.VIDEO);
        file.persist();
    }

    @Order(20)
    @Test
    @Transactional
    public void FileToString(){

        D_File file = new D_File("Latein Example","/assets/LateinvideoExample.mp4",ContentType.VIDEO);
        file.persist();


        assertThat(file.toString()).isEqualTo("File{id=1, name='Latein Example', path='/assets/LateinvideoExample.mp4', contentType=VIDEO}");

    }

}
