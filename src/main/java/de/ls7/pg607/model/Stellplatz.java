package de.ls7.pg607.model;


import com.vividsolutions.jts.geom.Point;
import org.hibernate.annotations.Type;

import javax.persistence.*;


/**
 * Created by lukas on 14.05.2017.
 */

@Entity
@Table(name = "stellplaetze")
public class Stellplatz {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "stellplatz_name")
    private String name;

    private Point location;

    /**
     * Default constructor required.
     */
    protected Stellplatz() {

    }

    public Stellplatz(String name, Point p) {
        this.name = name;
        this.location = p;
    }

    @Override
    public String toString() {
        return "Stellplatz{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", location=" + location.toString() +
                '}';
    }
}
