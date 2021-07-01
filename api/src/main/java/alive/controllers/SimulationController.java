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

    @PostMapping("matrix/{width}x{height}")
    public Integer createSimulation(@PathVariable("width") Integer width, @PathVariable("height") Integer height) {
        var simulation = simulationFieldFactory.createSimulation(width, height);
        simulation.start();
        return simulationsHolder.put(simulation);
    }

    @GetMapping("matrix/{id}")
    public Entity[][] getSimulation(@PathVariable("id") Integer id) {
        return simulationsHolder.get(id).state();
    }

    @PutMapping("matrix/{id}/{count}")
    public void nextTurn(@PathVariable("id") Integer id, @PathVariable("count") Integer count){
        for (int i = 0; i < count; i++){
            simulationsHolder.get(id).update();
        }
    }

    @DeleteMapping("matrix/{id}")
    public void removeSimulation(@PathVariable("id") Integer id) {
        simulationsHolder.remove(id);
    }
}
