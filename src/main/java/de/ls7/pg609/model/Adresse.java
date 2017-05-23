package de.ls7.pg609.model;

import javax.persistence.*;

/**
 * Created by lukas on 23.05.17.
 */
@Entity
@Table(name = "adresse")
public class Adresse {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "adress_id")
    private Long id;

    @Column(name = "land")
    private String land;

    @Column(name = "bundesland")
    private String bundesland;

    @Column(name = "plz")
    private int PLZ;

    @Column(name = "strasse")
    private String strasse;

    @Column(name = "haus_nummer")
    private int hausNummer;

    @Column(name = "haus_nummer_zusatz")
    private String hausNummerZusatz;

    protected Adresse() {

    }

    public Adresse(int PLZ, String bundesland, String land, String strasse, int hausNummer, String hausNummerZusatz) {
        this.PLZ = PLZ;
        this.bundesland = bundesland;
        this.land = land;
        this.strasse = strasse;
        this.hausNummer = hausNummer;
        this.hausNummerZusatz = hausNummerZusatz;
    }

    public Long getId() {
        return id;
    }

    public int getPLZ() {
        return PLZ;
    }

    public void setPLZ(int PLZ) {
        this.PLZ = PLZ;
    }

    public String getBundesland() {
        return bundesland;
    }

    public void setBundesland(String bundesland) {
        this.bundesland = bundesland;
    }

    public String getLand() {
        return land;
    }

    public void setLand(String land) {
        this.land = land;
    }

    public String getStraße() {
        return strasse;
    }

    public void setStraße(String strasse) {
        strasse = strasse;
    }

    public int getHausNummer() {
        return hausNummer;
    }

    public void setHausNummer(int hausNummer) {
        this.hausNummer = hausNummer;
    }

    public String getHausNummerZusatz() {
        return hausNummerZusatz;
    }

    public void setHausNummerZusatz(String hausNummerZusatz) {
        this.hausNummerZusatz = hausNummerZusatz;
    }


    public static final class AdressBuilder {
        private int PLZ;
        private String bundesland;
        private String land;
        private String strasse;
        private int hausNummer;
        private String hausNummerZusatz;

        private AdressBuilder() {
        }

        public static AdressBuilder anAdresse() {
            return new AdressBuilder();
        }

        public AdressBuilder withPLZ(int PLZ) {
            this.PLZ = PLZ;
            return this;
        }

        public AdressBuilder withBundesland(String bundesland) {
            this.bundesland = bundesland;
            return this;
        }

        public AdressBuilder withLand(String land) {
            this.land = land;
            return this;
        }

        public AdressBuilder withStraße(String strasse) {
            this.strasse = strasse;
            return this;
        }

        public AdressBuilder withHausNummer(int hausNummer) {
            this.hausNummer = hausNummer;
            return this;
        }

        public AdressBuilder withHausNummerZusatz(String hausNummerZusatz) {
            this.hausNummerZusatz = hausNummerZusatz;
            return this;
        }

        public Adresse build() {
            Adresse adresse = new Adresse();
            adresse.setPLZ(PLZ);
            adresse.setBundesland(bundesland);
            adresse.setLand(land);
            adresse.setStraße(strasse);
            adresse.setHausNummer(hausNummer);
            adresse.setHausNummerZusatz(hausNummerZusatz);
            return adresse;
        }
    }

    @Override
    public String toString() {
        return "Adresse{" +
                "id=" + id +
                ", PLZ=" + PLZ +
                ", bundesland='" + bundesland + '\'' +
                ", land='" + land + '\'' +
                ", Straße='" + strasse + '\'' +
                ", hausNummer=" + hausNummer +
                ", hausNummerZusatz='" + hausNummerZusatz + '\'' +
                '}';
    }
}
