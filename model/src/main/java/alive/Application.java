package alive;

import alive.entity.Alive;
import alive.simulation.SimulationField;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class Application {

    private final SimulationField simulation;

    private final Alive adam;

    public Application(SimulationField simulation, Alive adam) {
        this.simulation = simulation;
        this.adam = adam;
    }

    public static void main(String[] args) {
        var app = SpringApplication.run(Application.class, args);
        var main = app.getBean(Application.class);
        main.simulation.start();
    }
}
