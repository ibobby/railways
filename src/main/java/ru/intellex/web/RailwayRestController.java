package ru.intellex.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import ru.intellex.model.Railway;
import ru.intellex.service.RailwayService;

import java.util.List;

/**
 * Created by b.istomin on 27.03.2016.
 */
@RestController
@RequestMapping("/rest/railway/all")
public class RailwayRestController {

    private static Logger LOG = LoggerFactory.getLogger(RailwayRestController.class);

    @Autowired
    private RailwayService service;

    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Railway> getAll() {
        return  service.getAll();
    }

    @RequestMapping(value = "/withStations", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Railway> getAllWithStations() {
        return  service.getAllWithStations();
    }


}
