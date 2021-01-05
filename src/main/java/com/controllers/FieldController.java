package com.controllers;

import com.model.simulation.entities.Entity;
import com.model.simulation.field.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FieldController {

    Field field = new FieldLive(10, 10);
    Simulation simulation = new SimulationLive(field);

    public FieldController() {
        simulation.start();
    }

    @RequestMapping("/")
    public Entity[][] field() {

        return field.getCellsMatrix().getEntities();
    }
}
