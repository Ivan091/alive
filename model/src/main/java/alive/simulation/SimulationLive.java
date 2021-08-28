package alive.simulation;

import alive.entity.*;
import java.util.LinkedList;
import java.util.Queue;


public final class SimulationLive implements Simulation {

    private final Field field;

    private final Queue<Movable> olds = new LinkedList<>();

    private final Queue<Movable> newcomers = new LinkedList<>();

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
                var curEntity = newcomers.poll();
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

    private record AliveNewcomersVisitor(Queue<Movable> newcomers) implements Visitor {

        @Override
        public void visit(Movable movable) {
            if (movable.isRegistered()) {
                newcomers.add(movable);
            }
        }
    }
}
