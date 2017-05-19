package de.ls7.pg609;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * Dies ist die Mainklasse, welche die Springanwendung startet. Die @SpringBootApplication - Annotation ist beinhaltet
 * weitere Annotation, welche für die Autokonfigurierung benötigt werden. Mit dem aktuellem Setup wird nach Beans, wie
 * z.B. unten, und Konfiguration und Modelklassen in allen Paketen von de.ls7.pg609 gesucht.
 * <p>
 * Die ganze Anwendung läuft aktuell in einem eingebettetem Tomcat Container, so dass keine weitere Kofiguration nötig
 * ist.
 * Das ganze kann allerdings auch als .war gepackt werden, um es in einem bereits laufendem Tomcat zu betreiben.
 * <p>
 * Unter localhost:8080/swagger-ui.html findet man die auto generierte API-Dokumentation.
 */
@SpringBootApplication
public class RestPostGisDemoApplication implements CommandLineRunner {

    @Autowired
    JdbcTemplate jdbcTemplate;

    public static void main(String[] args) {
        SpringApplication.run(RestPostGisDemoApplication.class, args);
    }

    @Override
    public void run(String... strings) throws Exception {
        jdbcTemplate.execute("SELECT * FROM PARKPLATZ");
    }
}
