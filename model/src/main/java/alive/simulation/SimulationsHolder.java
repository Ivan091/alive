package alive.simulation;

public interface SimulationsHolder {
    SimulationField get(Integer id);
    Integer put(SimulationField simulationField);
    void remove(Integer id);
}
