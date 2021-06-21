package alive.simulation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.HashMap;
import java.util.Map;

@Component
public class SimulationsFieldHolder implements SimulationsHolder {

    private final Map<Integer, SimulationField> map;

    private Integer id;

    public SimulationsFieldHolder() {
        this(new HashMap<>(), 0);
    }

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
