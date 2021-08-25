package alive.controller;

import alive.config.SimulationFactory;
import alive.entity.Entity;
import alive.simulation.Simulation;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/simulation")
public class SimulationController {

    private final SimulationFactory simulationFactory;

    private Simulation simulation;

    public SimulationController(SimulationFactory simulationFactory) {
        this.simulationFactory = simulationFactory;
    }

    @PostMapping
    public void create(@RequestParam Integer width, @RequestParam Integer height) {
        this.simulation = simulationFactory.create(width, height);
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
