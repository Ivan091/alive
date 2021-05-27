package alive.simulation;

import alive.entity.Entity;
import java.util.LinkedList;
import java.util.List;


public class SimulationLive implements SimulationField {

    private final Field field;

    private final List<Entity> olds = new LinkedList<>();

    private final List<Entity> newcomers = new LinkedList<>();

    public SimulationLive(Field field) {
        this.field = field;
    }

    @Override
    public void start() {
        for (var i = 0; i < 1000; i++) {
            update();
            System.out.println(olds.size() + newcomers.size());
        }
    }

    @Override
    public void update() {
        runOlds();
        runNewComers();
    }

    private void runOlds() {
        var it = olds.iterator();
        while (it.hasNext()) {
            var alive = it.next();
            if (alive.isAlive()) {
                alive.makeAMove();
            } else {
                it.remove();
            }
        }
    }

    private void runNewComers() {
        var it = newcomers.iterator();
        while (it.hasNext()) {
            var entity = it.next();
            if (entity.isAlive()) {
                entity.makeAMove();
                olds.add(entity);
            }
            it.remove();
        }
    }

    @Override
    public void place(Entity entity, Position pos) {
        field.place(entity, pos);
        if (entity.isAlive()) {
            newcomers.add(entity);
        }
    }

    @Override
    public Entity search(Position pos) {
        return field.search(pos);
    }

    @Override
    public void empty(Position pos) {
        field.empty(pos);
    }

    @Override
    public void relocate(Position oldPos, Position newPos) {
        field.relocate(oldPos, newPos);
    }

    @Override
    public boolean isInBounds(Position pos) {
        return field.isInBounds(pos);
    }

    @Override
    public boolean isEmpty(Position pos) {
        return field.isEmpty(pos);
    }
}
