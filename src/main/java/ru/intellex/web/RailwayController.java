package ru.intellex.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.intellex.model.Railway;
import ru.intellex.service.RailwayService;


/**
 * Created by b.istomin on 26.02.2016.
 */
@Controller
public class RailwayController {

    @Autowired
    private RailwayService service;

    @RequestMapping(value = "/railway_list", method = RequestMethod.GET)
    public String projectList(Model model) {
        model.addAttribute("railwayList", service.getAll());
        return "railwayList";
    }

}
