package alive.entity.genome.gene;

import alive.common.Factory;
import alive.entity.Alive;
import alive.entity.genome.Gene;
import alive.entity.genome.Genome;
import org.springframework.stereotype.Component;


public class Replicate implements Gene {

    @Override
    public void affect(Alive owner, Genome genome) {
        owner.replicate();
        genome.incrementGeneIndex(1);
    }

    @Component
    public static final class GeneFactory implements Factory<Gene> {

        private final Gene replicate = new Replicate();

        @Override
        public Gene create() {
            return replicate;
        }
    }
}
