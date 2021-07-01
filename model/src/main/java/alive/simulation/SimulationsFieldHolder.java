package alive.simulation;

import java.util.Map;


public final class SimulationsFieldHolder implements SimulationsHolder {

    private final Map<Integer, SimulationField> map;

    private Integer id;

    public SimulationsFieldHolder(Map<Integer, SimulationField> map, Integer id) {
        this.map = map;
        this.id = id;
    }

    @Override
    public SimulationField get(Integer id) {
        return map.get(id);
    }

    @Override
    public Integer put(SimulationField simulationField) {
        id++;
        map.put(id, simulationField);
        return id;
    }

    @Override
    public void remove(Integer id) {
        map.remove(id);
    }
}
