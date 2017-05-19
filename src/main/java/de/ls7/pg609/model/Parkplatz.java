package de.ls7.pg609.model;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by lukas on 19.05.2017.
 */
@Entity
@Table(name = "PARKPLATZ")
public class Parkplatz {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "PARKPLATZ_ID")
    private Long id;

    @Column(name = "stellplatz_name")
    private String name;

    @OneToMany
    @JoinTable(
            name="PARKPLATZ_OEFFNUNGSZEITEN",
            joinColumns = @JoinColumn(name = "OEFFNUNGSZEITEN_ID"),
            inverseJoinColumns = @JoinColumn(name = "PARKPLATZ_ID")
    )
    private Set<Oeffnungszeiten> offnungszeiten;

    public Parkplatz() {

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

    public Set<Oeffnungszeiten> getOffnungszeiten() {
        return offnungszeiten;
    }

    public void setOffnungszeiten(Set<Oeffnungszeiten> offnungszeiten) {
        this.offnungszeiten = offnungszeiten;
    }

    @Override
    public String toString() {
        return "Parkplatz{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", offnungszeiten=" + offnungszeiten +
                '}';
    }
}
