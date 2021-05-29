package alive;

import alive.entity.Entity;
import alive.simulation.SimulationField;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class Application {

    private final SimulationField simulation;

    public Application(SimulationField simulation, Entity adam) {
        this.simulation = simulation;
        adam.register();
    }

    public static void main(String[] args) {
        var app = SpringApplication.run(Application.class, args);
        var main = app.getBean(Application.class);
        main.simulation.start();
    }
}
