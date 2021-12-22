package at.htl.entity;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "D_ACCESS_TOKEN")
public class AccessToken extends PanacheEntityBase {

    @Id
    String token;

    @ManyToOne
    @JoinColumn(name = "AT_COURSE")
    Course course;

    @Column(name = "AT_ACTIVATION_DATE")
    LocalDate activationDate;

    @Column(name = "AT_DAYS_VALID")
    int daysValid;

    @Column(name = "AT_EXPIRE_DATE")
    LocalDate expireDate;

    public AccessToken(Course course, int daysValid, LocalDate expireDate) {
        this();
        this.course = course;
        this.daysValid = daysValid;
        this.expireDate = expireDate;
    }

    public AccessToken( Course course) {
        this();
        this.course = course;
    }

    public AccessToken() {
        this.token = null;
    }



}
