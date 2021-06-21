package alive.controllers;

import alive.config.SimulationFieldFactory;
import alive.entity.Entity;
import alive.simulation.SimulationsHolder;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api")
public class SimulationController {

    private final SimulationFieldFactory simulationFieldFactory;

    private final SimulationsHolder simulationsHolder;

    public SimulationController(SimulationFieldFactory simulationFieldFactory, SimulationsHolder simulationsHolder) {
        this.simulationFieldFactory = simulationFieldFactory;
        this.simulationsHolder = simulationsHolder;
    }

    @PostMapping("matrix/create/{width}x{height}")
    public Integer createSimulation(@PathVariable("width") Integer width, @PathVariable("height") Integer height){
        return simulationsHolder.put(simulationFieldFactory.createSimulation(width, height));
    }

    @GetMapping("matrix/get/{id}")
    public Entity[][] getSimulation(@PathVariable("id") Integer id){
        return simulationsHolder.get(id).state();
    }
}
