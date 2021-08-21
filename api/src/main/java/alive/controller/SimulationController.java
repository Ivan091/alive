package alive.controller;

import alive.config.SimulationFactory;
import alive.entity.Entity;
import alive.simulation.Simulation;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("/api/simulation")
public class SimulationController {

    private final SimulationFactory simulationFactory;

    private Simulation simulation;

    public SimulationController(SimulationFactory simulationFactory) {
        this.simulationFactory = simulationFactory;
    }

    @PostMapping
    @ResponseBody
    public void create(@RequestParam("width") Integer width, @RequestParam("height") Integer height) {
        this.simulation = simulationFactory.create(width, height);
    }

    @PutMapping
    @ResponseBody
    public Entity[][] update(@RequestParam("count") Integer count) {
        count = Math.max(count, 0);
        for (int i = 0; i < count; i++) {
            simulation.update();
        }
        return simulation.state();
    }

    @SendTo("/topic/simulation")
    @MessageMapping("/simulation")
    public Entity[][] update_ws(Integer count) {
        return update(count);
    }
}
