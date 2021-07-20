package at.htl.entity;


import io.quarkus.hibernate.orm.panache.PanacheEntityBase;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "D_LEVEL")
public class Level extends PanacheEntityBase {

    @Id
    public String id;
    public String descr;

    //region constructors
    public Level(String id) {
        this.id = id;
    }

    public Level(String id, String descr) {
        this.id = id;
        this.descr = descr;
    }

    public Level() {
    }
    //endregion


}
