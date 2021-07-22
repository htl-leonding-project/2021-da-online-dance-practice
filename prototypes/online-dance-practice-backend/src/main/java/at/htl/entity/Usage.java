package at.htl.entity;


import io.quarkus.hibernate.orm.panache.PanacheEntityBase;

import javax.persistence.*;

@Entity
@Table(name = "D_USAGE")
public class Usage extends PanacheEntityBase {

    @Id
    public Long id;

    @JoinColumn(name = "U_COURSE")
    @ManyToOne(cascade = {CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
    public Course course;

    @JoinColumn(name = "U_FILE")
    @ManyToOne(cascade = {CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
    public File file;


    //region constructor

    public Usage(Course course, File file) {
        this.course = course;
        this.file = file;
    }

    public Usage() {
    }

    //endregion


    @Override
    public String toString() {
        return "Usage{" +
                "id=" + id +
                ", course=" + course +
                ", file=" + file +
                '}';
    }
}
