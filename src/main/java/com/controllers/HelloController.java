package com.controllers;

import com.model.simulation.field.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class HelloController {

    Field field = new FieldLive(10, 10);
    Simulation simulation = new SimulationLive(field);

    public HelloController() {
        simulation.start();
    }

    @RequestMapping("/")
    public ModelAndView gene() {
        var mav = new ModelAndView("greeting");
        mav.addObject("field", simulation.currentCondition());
        simulation.nextMove();
        return mav;
    }
}
