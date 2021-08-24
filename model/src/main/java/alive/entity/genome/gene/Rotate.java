package alive.entity.genome.gene;

import alive.common.Factory;
import alive.entity.Alive;
import alive.entity.genome.Gene;
import alive.entity.genome.Genome;
import org.springframework.stereotype.Component;
import java.util.Random;


public record Rotate(int key) implements Gene {

    @Override
    public void affect(Alive owner, Genome genome) {
        owner.rotate(key);
        genome.incrementGeneIndex(1);
    }

    @Component
    public static final class GeneFactory implements Factory<Gene> {

        private final Random random = new Random();

        @Override
        public Gene create() {
            return new Rotate(random.nextInt(8) + 1);
        }
    }
}
