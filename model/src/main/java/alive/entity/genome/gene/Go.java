package alive.entity.genome.gene;

import alive.common.Factory;
import alive.entity.Alive;
import alive.entity.genome.Gene;
import alive.entity.genome.Genome;
import org.springframework.stereotype.Component;


public final class Go implements Gene {

    @Override
    public void affect(Alive owner, Genome genome) {
        owner.goAhead();
        owner.heal(-51);
        genome.incrementGeneIndex(1);
    }

    @Component
    public static final class GeneFactory implements Factory<Gene> {

        @Override
        public Gene create() {
            return new Go();
        }
    }
}
