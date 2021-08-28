package alive.entity.genome.gene;

import alive.common.Factory;
import alive.entity.Alive;
import alive.entity.genome.Gene;
import alive.entity.genome.Genome;
import org.springframework.stereotype.Component;
import java.util.Random;


public record IndexJump(int key) implements Gene {

    @Override
    public void affect(Alive owner, Genome genome) {
        genome.incrementGeneIndex(key);
        owner.heal(-key * 10);
        genome.affect(owner);
    }

    @Component
    public static final class GeneFactory implements Factory<Gene> {

        private final Random random;

        public GeneFactory(Random random) {
            this.random = random;
        }

        @Override
        public Gene create() {
            return new IndexJump(random.nextInt(8) + 1);
        }
    }
}
