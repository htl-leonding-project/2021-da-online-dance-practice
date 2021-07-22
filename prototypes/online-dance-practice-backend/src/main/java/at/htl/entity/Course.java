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
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "C_COURSEID")
    public Long courseId;

    @Column(name = "C_TITLE")
    public String title;

    @Column(name = "C_DESCR")
    public String descr;

    @ManyToOne
    @JoinColumn(name ="C_LEVEL")
    public Level level;


    //region constructors
    public Course(Long courseId, String title, String descr, Level level) {
        this.courseId = courseId;
        this.title = title;
        this.descr = descr;
        this.level = level;
    }

    public Course() {
    }
    //endregion


    @Override
    public String toString() {
        return "Course{" +
                "courseId=" + courseId +
                ", title='" + title + '\'' +
                ", descr='" + descr + '\'' +
                ", level=" + level +
                '}';
    }
}

