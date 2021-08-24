package alive.entity.genome.gene;

import alive.common.Factory;
import alive.entity.*;
import alive.entity.genome.Gene;
import alive.entity.genome.Genome;
import org.springframework.stereotype.Component;


public final class Eat implements Gene {

    @Override
    public void affect(Alive owner, Genome genome) {
        owner.look().ifPresent(other -> {
            new HealthVisitor(owner).visit(other);
            owner.repaint(c -> c.remix(100, -50, -50));
        });
        genome.incrementGeneIndex(1);
    }

    private static record HealthVisitor(Alive owner) implements Visitor {

        @Override
        public void visit(Entity entity) {
            entity.unregister();
        }

        @Override
        public void visit(Alive organic) {
            owner.heal(organic.health());
            organic.heal(organic.health());
        }

        @Override
        public void visit(Organic organic) {
            owner.heal(organic.health());
            organic.heal(organic.health());
        }
    }

    @Component
    public static class GeneFactory implements Factory<Gene> {

        @Override
        public Gene create() {
            return new Eat();
        }
    }
}
