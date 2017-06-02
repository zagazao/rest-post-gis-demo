package de.ls7.pg609.restapi;

import de.ls7.pg609.model.Parkplatz;
import de.ls7.pg609.repository.ParkplatzRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by lukas on 29.05.2017.
 */
@RestController
@RequestMapping(value = "parkplatz")
public class ParkplatzController {


    private final ParkplatzRepository parkplatzRepository;

    @Autowired
    public ParkplatzController(final ParkplatzRepository parkplatzRepository) {
        this.parkplatzRepository = parkplatzRepository;
    }

    @RequestMapping(value = "/json", method = RequestMethod.GET, produces = {"application/json"})
    public @ResponseBody
    ResponseEntity<Iterable<Parkplatz>> getParkplaetze() {
        return new ResponseEntity<>(parkplatzRepository.findAll(), HttpStatus.OK);
    }


    //TODO: Find nearest parkplatz(in Radius)


}
