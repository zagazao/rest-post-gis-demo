package de.ls7.pg609.restapi;

import com.vividsolutions.jts.geom.Coordinate;
import com.vividsolutions.jts.geom.GeometryFactory;
import com.vividsolutions.jts.geom.Point;
import de.ls7.pg609.model.Stellplatz;
import de.ls7.pg609.repository.ParkplatzRepository;
import de.ls7.pg609.repository.StellplatzRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by lukas on 14.05.2017.
 */
@RestController
@RequestMapping("/api")
public class StellplatzController {

    @Autowired
    private StellplatzRepository stellplatzRepository;

    @Autowired
    private ParkplatzRepository parkplatzRepository;

    private GeometryFactory geometryFactory = new GeometryFactory();

    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public void endpunktTest() {
        System.out.println("Method endpunktTest was called.");
    }

    @RequestMapping(value = "/list", method = RequestMethod.GET, produces = {"application/json"})
    public @ResponseBody
    ResponseEntity<Iterable<Stellplatz>> listStellplaetze() {
        System.out.println(stellplatzRepository.findAll());
        System.out.println(parkplatzRepository.findAll());
        return new ResponseEntity<Iterable<Stellplatz>>(stellplatzRepository.findAll(), HttpStatus.OK);
    }


    @RequestMapping(value = "/createStellplatz", method = RequestMethod.POST)
    public void postStellplatz(String name, double lattitude, double longitude) {
        Point p = geometryFactory.createPoint(new Coordinate(longitude, lattitude));
        stellplatzRepository.save(new Stellplatz(name, p));
        System.out.println(stellplatzRepository.findAll());
    }

}
