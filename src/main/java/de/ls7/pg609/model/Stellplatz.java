package de.ls7.pg609.model;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.vividsolutions.jts.geom.Geometry;
import com.vividsolutions.jts.geom.Point;
import de.ls7.pg609.model.desirialize.JsonToPointDeserializer;
import de.ls7.pg609.model.desirialize.PointToJsonSerializer;

import javax.persistence.*;
import java.sql.Time;

@Entity
@Table(name = "stellplaetze")
public class Stellplatz {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "stellplatz_name")
    private String name;

    @JsonSerialize(using = PointToJsonSerializer.class)
    @JsonDeserialize(using = JsonToPointDeserializer.class)
    private Point location;

    @Enumerated
    private ParkplatzZustand zustand;

    private Geometry geometry;

    private Time startTime;

    private Time endTime;

    /**
     * Default constructor required.
     */
    protected Stellplatz() {

    }

    public Stellplatz(String name, Point p) {
        this.name = name;
        this.location = p;
        this.startTime = java.sql.Time.valueOf( "07:05:00" );
        this.endTime = java.sql.Time.valueOf( "19:05:00" );
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Point getLocation() {
        return location;
    }

    public void setLocation(Point location) {
        this.location = location;
    }

    public Time getStartTime() {
        return startTime;
    }

    public void setStartTime(Time startTime) {
        this.startTime = startTime;
    }

    public Time getEndTime() {
        return endTime;
    }

    public void setEndTime(Time endTime) {
        this.endTime = endTime;
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
