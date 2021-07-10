package alive.config;

import alive.simulation.Simulation;


public interface SimulationFactory {

    Simulation create(int width, int height);
}
