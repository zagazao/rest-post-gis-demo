package de.ls7.pg609.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.util.Date;
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

    /**
     * Gibt true zurück, falls der Parkplatz zu dem übergebenem Datum geöffnet ist.
     * @param date Datum zum checken der Öffnungszeiten
     * @return true, falls geöffnet
     */
    public boolean isOpened(Date date) {
        for (Öffnungszeiten öffnungszeiten : offnungszeiten) {
            if (öffnungszeiten.isOpened(date)) {
                return true;
            }
        }
        return false;
    }
}
