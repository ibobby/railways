package ru.intellex.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import ru.intellex.model.Railway;
import ru.intellex.model.Station;
import ru.intellex.service.RailwayService;
import ru.intellex.service.StationService;

import java.util.List;

/**
 * Created by b.istomin on 05.04.2016.
 */
@RestController
@RequestMapping("/rest/station/all")
public class StationRestController {

    private static Logger LOG = LoggerFactory.getLogger(StationRestController.class);

    @Autowired
    private StationService service;

    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Station> getAll() {
        return  service.getAll();
    }

    @RequestMapping(value = "/withRailways", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Station> getAllWithRailways() {
        return  service.getAllWithRailways();
    }

}
