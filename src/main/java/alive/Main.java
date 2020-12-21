package alive;

import alive.field.FieldLive;
import alive.field.SimulationLive;

public class Main {

    public static void main(String[] args) {
        start();
    }

    public static void start() {
        var simulation = new SimulationLive(new FieldLive(100, 100));
        simulation.start();
    }
}