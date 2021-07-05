package at.htl.entity;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import org.hibernate.annotations.GeneratorType;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "D_COURSE")
public class Course extends PanacheEntityBase {

    @Id
    public String type;

    @Enumerated(EnumType.STRING)
    Content content;

    @Enumerated(EnumType.STRING)
    Level level;

    public Course(String type, Content content, Level level) {
        this.type = type;
        this.content = content;
        this.level = level;
    }

    public Course() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Course course = (Course) o;
        return Objects.equals(type, course.type) && content == course.content && level == course.level;
    }

    @Override
    public int hashCode() {
        return Objects.hash(type, content, level);
    }
}
