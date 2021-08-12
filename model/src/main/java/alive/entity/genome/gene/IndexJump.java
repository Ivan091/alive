package alive.entity.genome.gene;

import alive.common.Factory;
import alive.entity.Alive;
import alive.entity.genome.Gene;
import alive.entity.genome.Genome;
import org.springframework.stereotype.Component;
import java.util.Random;


public record IndexJump(int key) implements Gene {

    @Override
    public void affect(Alive alive, Genome genome) {
        genome.incrementGeneIndex(key);
        genome.affect(alive);
    }

    @Component
    public static final class GeneFactory implements Factory<Gene> {

        private final Random random = new Random();

        @Override
        public Gene create() {
            return new IndexJump(random.nextInt(8) + 1);
        }
    }
}
