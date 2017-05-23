package de.ls7.pg609.model;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by lukas on 19.05.2017.
 */
@Entity
@Table(name = "parkplatz")
public class Parkplatz {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "parkplatz_id")
    private Long id;

    @Column(name = "stellplatz_name")
    private String name;

    @OneToMany
    @JoinTable(
            name = "PARKPLATZ_OEFFNUNGSZEITEN",
            joinColumns = @JoinColumn(name = "OEFFNUNGSZEITEN_ID"),
            inverseJoinColumns = @JoinColumn(name = "parkplatz_id")
    )
    private Set<Öffnungszeiten> offnungszeiten;

    @OneToOne
    private Adresse adresse;

    public Parkplatz() {

    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Öffnungszeiten> getOffnungszeiten() {
        return offnungszeiten;
    }

    public void setOffnungszeiten(Set<Öffnungszeiten> offnungszeiten) {
        this.offnungszeiten = offnungszeiten;
    }

    public Adresse getAdresse() {
        return adresse;
    }

    public void setAdresse(Adresse adresse) {
        this.adresse = adresse;
    }

    @Override
    public String toString() {
        return "Parkplatz{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", offnungszeiten=" + offnungszeiten +
                ", adresse=" + adresse +
                '}';
    }
}
