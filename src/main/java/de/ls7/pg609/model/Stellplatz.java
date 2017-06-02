package de.ls7.pg609.model;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import com.vividsolutions.jts.geom.Point;
import de.ls7.pg609.model.desirialize.JsonToPointDeserializer;
import de.ls7.pg609.model.desirialize.PointToJsonSerializer;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Set;

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

    @ElementCollection
    private Set<Berechtigung> berechtigungen;

    @Column(name = "max_parking_duration")
    private Long höchstParkDauer;

    //TODO: AusrichtungsParser zu etwas sinnvollem.
    private String ausrichtungen;

    /**
     * Default constructor required.
     */
    protected Stellplatz() {

    }

    public Stellplatz(String name, Point p) {
        this.name = name;
        this.location = p;
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

    public ParkplatzZustand getZustand() {
        return zustand;
    }

    public void setZustand(ParkplatzZustand zustand) {
        this.zustand = zustand;
    }

    public Set<Berechtigung> getBerechtigungen() {
        return berechtigungen;
    }

    public void setBerechtigungen(Set<Berechtigung> berechtigungen) {
        this.berechtigungen = berechtigungen;
    }

    public Long getHöchstParkDauer() {
        return höchstParkDauer;
    }

    public void setHöchstParkDauer(Long höchstParkDauer) {
        this.höchstParkDauer = höchstParkDauer;
    }
}
