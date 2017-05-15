package de.ls7.pg607.repository;

import de.ls7.pg607.model.Stellplatz;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Dieses Interface gibt Zugriff auf die Datenbank.
 */
public interface StellplatzRepository extends CrudRepository<Stellplatz, Long> {

    /**
     * Für Methoden, welche nach diesem Schema generiert werden, werden automatische SQL-Queries geschrieben.
     * Hier können werden z.B. alle Stellplätze aus der Datenbank mit dem Name "name" als Liste zurückgegeben.
     *
     * @param name
     * @return
     */
    List<Stellplatz> findByName(String name);
}
