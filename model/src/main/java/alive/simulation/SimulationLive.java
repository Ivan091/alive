package alive.simulation;

import alive.entity.*;
import java.util.ArrayList;
import java.util.List;


public final class SimulationLive implements Simulation {

    private final Field field;

    private final List<Movable> olds = new ArrayList<>();

    private final List<Movable> newcomers = new ArrayList<>();

    private final Visitor visitor = new AliveNewcomersVisitor(newcomers);

    public SimulationLive(Field field) {
        this.field = field;
    }

    @Override
    public void update() {
        try {
            var oldsIt = olds.iterator();
            while (oldsIt.hasNext()) {
                var curEntity = oldsIt.next();
                if (curEntity.isRegistered()) {
                    curEntity.makeAMove();
                } else {
                    oldsIt.remove();
                }
            }
            while (!newcomers.isEmpty()) {
                var curEntity = newcomers.remove(newcomers.size() - 1);
                if (curEntity.isRegistered()) {
                    curEntity.makeAMove();
                    olds.add(curEntity);
                }
            }
        } catch (Throwable t) {
            t.printStackTrace();
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

    private record AliveNewcomersVisitor(List<Movable> newcomers) implements Visitor {

        @Override
        public void visit(Movable movable) {
            if (movable.isRegistered()) {
                newcomers.add(movable);
            }
        }
    }
}
