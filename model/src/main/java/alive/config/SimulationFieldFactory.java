package alive.config;

import alive.simulation.SimulationField;


public interface SimulationFieldFactory {

    SimulationField createSimulation(int width, int height);
}
