package alive.entity.genome.gene;

import alive.common.Factory;
import alive.entity.Alive;
import alive.entity.genome.Gene;
import alive.entity.genome.Genome;
import org.springframework.stereotype.Component;


public final class Photosynthesis implements Gene {

    private static final int HEAL = 25;

    @Override
    public void affect(Alive owner, Genome genome) {
        owner.repaint(c -> c.remix(-HEAL >> 4, HEAL >> 3, -HEAL >> 4));
        owner.heal(HEAL);
        genome.incrementGeneIndex(1);
    }

    @Component
    public static final class GeneFactory implements Factory<Gene> {

        @Override
        public Gene create() {
            return new Photosynthesis();
        }
    }
}
