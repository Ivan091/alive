package com.controllers;

import com.model.simulation.Simulation;
import com.model.simulation.SimulationLive;
import com.model.simulation.entities.Entity;
import com.model.simulation.field.FieldLive;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.stream.IntStream;

@RestController
@RequestMapping("/api/field")
public class FieldController {

    Simulation simulation = new SimulationLive(new FieldLive(200, 80));

    public FieldController() {
        simulation.start();
    }

    @RequestMapping("/update")
    public void update() {
        IntStream.range(0, 20).forEach(i -> simulation.nextMove());
    }

    @RequestMapping("/status")
    public Entity[][] field() {
        return simulation.getField().getCellsMatrix().getEntities();
    }
}
