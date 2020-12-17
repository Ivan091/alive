package alive;

import alive.field.LiveSimulation;
import alive.field.MainField;

public class Main {

    public static void main(String[] args) {
        start();
    }

    public static void start() {
        var simulation = new LiveSimulation(new MainField(30, 30));
        simulation.start();
    }
}