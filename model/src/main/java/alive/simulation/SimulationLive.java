package alive.simulation;

import alive.entity.*;
import java.util.*;


public final class SimulationLive implements Simulation {

    private final Field field;

    private final List<Movable> olds = new LinkedList<>();

    private final List<Movable> newcomers = new ArrayList<>();

    private final Visitor visitor = new AliveNewcomersVisitor(newcomers);

    public SimulationLive(Field field) {
        this.field = field;
    }

    @Override
    public void update() {
        try {
            for (var it = olds.iterator(); it.hasNext(); ) {
                var movable = it.next();
                if (movable.isRegistered()) {
                    movable.makeAMove();
                } else {
                    it.remove();
                }
            }
            olds.addAll(newcomers);
            newcomers.clear();
        } catch (Exception t) {
            t.printStackTrace();
            throw t;
        }
    }

    @Override
    public void place(Entity entity, Position pos) {
        field.place(entity, pos);
        entity.accept(visitor);
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

    @Override
    public Entity[][] state() {
        return field.state();
    }

    private record AliveNewcomersVisitor(Collection<Movable> list) implements Visitor {

        @Override
        public void visit(Movable movable) {
            if (movable.isRegistered()) {
                list.add(movable);
            }
        }
    }
}
