package alive.controllers;

import alive.config.SimulationFactory;
import alive.entity.Entity;
import alive.simulation.Simulation;
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
    public void create(@RequestParam("width") Integer width, @RequestParam("height") Integer height) {
        this.simulation = simulationFactory.create(width, height);
    }

    @PutMapping
    public Entity[][] update(@RequestParam("count") Integer count){
        count = Math.max(count, 0);
        for (int i = 0; i < count; i++){
            simulation.update();
        }
        return simulation.state();
    }
}
