package alive;

import alive.simulation.Simulation;
import org.springframework.stereotype.Component;


@Component
public class Starter {

    public Simulation simulation;

    public Starter(Simulation simulation) {
        simulation.start();
    }
}
