package alive.simulation;

public interface SimulationsHolder {

    Simulation get(Integer id);

    Integer put(Simulation simulation);

    void remove(Integer id);
}
