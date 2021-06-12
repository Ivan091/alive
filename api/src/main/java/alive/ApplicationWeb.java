package alive;

import alive.entity.Entity;
import alive.simulation.SimulationField;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class ApplicationWeb {

    private final SimulationField simulation;

    public ApplicationWeb(SimulationField simulation, Entity adam) {
        this.simulation = simulation;
        adam.register();
    }

    public static void main(String[] args) {
        var context = SpringApplication.run(ApplicationWeb.class, args);
        var main = context.getBean(ApplicationWeb.class);
        main.simulation.start();
    }
}
