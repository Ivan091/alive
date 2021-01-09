package com.controllers;

import com.model.simulation.entities.Entity;
import com.model.simulation.field.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.stream.IntStream;

@Controller
public class FieldController {

    Field field = new FieldLive(200, 80);
    Simulation simulation = new SimulationLive(field);

    public FieldController() {
        simulation.start();
    }

    @RequestMapping
    public String game() {
        return "field";
    }

    @ResponseBody
    @RequestMapping("/field-update")
    public String update() {
        IntStream.range(0, 20).forEach(i -> simulation.nextMove());
        return "updated";
    }

    @ResponseBody
    @RequestMapping("/field")
    public Entity[][] field() {
        return field.getCellsMatrix().getEntities();
    }
}
