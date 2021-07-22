package at.htl.entity;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;

import javax.persistence.*;

@Entity
@Table(name = "D_BOOKING")
public class Booking extends PanacheEntityBase {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "B_BOOKINGID")
    public Long bookingId;

    @ManyToOne
    @JoinColumn(name = "B_USERID")
    public User user;

    @ManyToOne
    @JoinColumn(name = "B_COURSEID")
    public Course course;

    //region constructors
    public Booking() {
    }

    public Booking(User user, Course course) {
        this.user = user;
        this.course = course;
    }

    @Override
    public String toString() {
        return "Booking{" +
                "bookingId=" + bookingId +
                ", user=" + user +
                ", course=" + course +
                '}';
    }
    //region constructors

}
