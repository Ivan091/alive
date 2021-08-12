package alive.entity.genome.gene;

import alive.common.Factory;
import alive.entity.Alive;
import alive.entity.genome.Gene;
import alive.entity.genome.Genome;
import org.springframework.stereotype.Component;


@Component
public final class Photosynthesis implements Gene {

    @Override
    public void affect(Alive alive, Genome genome) {
        alive.heal(20);
        alive.repaint(c -> c.remix(-10, 20, -10));
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
