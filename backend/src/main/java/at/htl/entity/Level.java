package at.htl.entity;


import io.quarkus.hibernate.orm.panache.PanacheEntity;
import io.quarkus.hibernate.orm.panache.PanacheEntityBase;

import javax.persistence.*;

@Entity
@Table(name = "D_LEVEL")
public class Level extends PanacheEntityBase {

    @Id
    @Column(name = "L_LEVELID")
    public String levelId;

    @Column(name = "L_DESCRIPTION")
    public String description;

    //region constructors
    public Level() {
    }

    public Level(String levelId, String description) {
        this.levelId = levelId;
        this.description = description;
    }

    //endregion

    @Override
    public String toString() {
        return "Level{" +
                "levelId='" + levelId + '\'' +
                ", description='" + description + '\'' +
                '}';
    }

}