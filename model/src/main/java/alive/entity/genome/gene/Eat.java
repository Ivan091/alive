package alive.entity.genome.gene;

import alive.common.Factory;
import alive.entity.*;
import alive.entity.genome.Gene;
import alive.entity.genome.Genome;
import org.springframework.stereotype.Component;


public final class Eat implements Gene {

    @Override
    public void affect(Alive owner, Genome genome) {
        owner.look().ifPresent(other -> other.accept(new HealthVisitor(owner)));
        owner.heal(-21);
        genome.incrementGeneIndex(1);
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
            owner.repaint(c -> c.reset(dHealth >> 3, -dHealth >> 4, -dHealth >> 4));
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

    @Component
    public static final class GeneFactory implements Factory<Gene> {

        @Override
        public Gene create() {
            return new Eat();
        }
    }
}
