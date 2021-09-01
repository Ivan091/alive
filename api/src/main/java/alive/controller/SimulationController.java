package alive.controller;

import alive.entity.Entity;
import alive.simulation.Simulation;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.web.bind.annotation.*;
import java.util.function.BiFunction;


@RestController
@RequestMapping("/api/simulation")
public class SimulationController {

    private final BiFunction<Integer, Integer, Simulation> simulationFactory;

    private Simulation simulation;

    public SimulationController(BiFunction<Integer, Integer, Simulation> simulationFactory) {
        this.simulationFactory = simulationFactory;
    }

    @PostMapping
    public void create(@RequestParam Integer width, @RequestParam Integer height) {
        this.simulation = simulationFactory.apply(width, height);
    }

    @PutMapping
    public Entity[][] update(@RequestParam Integer count) {
        return update_socket(count);
    }

    @SendTo("/topic/simulation")
    @MessageMapping("/app/simulation")
    public Entity[][] update_socket(Integer count) {
        count = Math.max(count, 0);
        for (int i = 0; i < count; i++) {
            simulation.update();
        }
        return simulation.state();
    }
}
