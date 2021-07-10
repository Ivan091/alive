package alive.simulation;

import java.util.Map;


public final class SimulationsFieldHolder implements SimulationsHolder {

    private final Map<Integer, Simulation> map;

    private Integer id;

    public SimulationsFieldHolder(Map<Integer, Simulation> map, Integer id) {
        this.map = map;
        this.id = id;
    }

    @Override
    public Simulation get(Integer id) {
        return map.get(id);
    }

    @Override
    public Integer put(Simulation simulation) {
        id++;
        map.put(id, simulation);
        return id;
    }

    @Override
    public void remove(Integer id) {
        map.remove(id);
    }
}
