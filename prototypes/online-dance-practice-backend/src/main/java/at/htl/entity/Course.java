package at.htl.entity;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import org.hibernate.annotations.GeneratorType;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "D_COURSE")
public class Course extends PanacheEntityBase {

    @Id
    public String type;

    @ElementCollection(targetClass=Content.class)
    @Enumerated(EnumType.STRING) // Possibly optional (I'm not sure) but defaults to ORDINAL.
    @CollectionTable(name="person_interest")
    @Column(name = "content")
    List<Content> contents = new ArrayList<Content>();

    @Enumerated(EnumType.STRING)
    Level level;

    public Course() {
    }

    public Course(String type, List<Content> contents, Level level) {
        this.type = type;
        this.contents = contents;
        this.level = level;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Course course = (Course) o;
        return Objects.equals(type, course.type) && Objects.equals(contents, course.contents) && level == course.level;
    }

    @Override
    public int hashCode() {
        return Objects.hash(type, contents, level);
    }
}
