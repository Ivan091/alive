package alive.entity.genome.gene.command;

import alive.entity.*;
import alive.entity.genome.Gene;
import alive.entity.genome.Genome;


public record Eat() implements Gene {

    @Override
    public void affect(Alive owner, Genome genome) {
        owner.look().ifPresent(other -> other.accept(new HealthVisitor(owner)));
    }

    private static record HealthVisitor(Alive owner) implements Visitor {

        @Override
        public void visit(Entity entity) {
            entity.unregister();
        }

        @Override
        public void visit(Organic organic) {
            var dHealth = organic.health();
            owner.heal(dHealth);
            owner.repaint(c -> c.remix(dHealth / 60, -dHealth / 128, -dHealth / 128));
            organic.unregister();
        }

        @Override
        public void visit(Alive alive) {
            if (owner.isFriendly(alive)) {
                return;
            }
            visit((Organic) alive);
        }
    }
}
