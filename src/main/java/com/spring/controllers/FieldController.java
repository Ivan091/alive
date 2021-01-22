package com.spring.controllers;

import com.domain.simulation.Simulation;
import com.domain.simulation.SimulationLive;
import com.domain.simulation.entities.Entity;
import com.domain.simulation.field.FieldLive;
import org.springframework.web.bind.annotation.*;

import java.util.stream.IntStream;

@RestController
@RequestMapping("/api/field")
public class FieldController {

    Simulation simulation = new SimulationLive(new FieldLive(100, 40));

    public FieldController() {
        simulation.start();
    }

    @RequestMapping(value = "/update", method = RequestMethod.HEAD)
    public void update() {
        IntStream.range(0, 4).forEach(i -> simulation.nextMove());
    }

    @RequestMapping("/status")
    public Entity[][] field() {
        return simulation.getField().cellsMatrix().getEntities();
    }
}
