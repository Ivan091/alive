package com.model.simulation;

import com.model.simulation.field.FieldLive;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Main {

    public static void main(String[] args) {
        start();
    }

    public static void start() {
        var simulation = new SimulationLive(new FieldLive(10, 10));
        simulation.start();
    }
}