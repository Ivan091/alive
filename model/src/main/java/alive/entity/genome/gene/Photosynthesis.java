package alive.entity.genome.gene;

import alive.common.Factory;
import alive.entity.Alive;
import alive.entity.genome.Gene;
import alive.entity.genome.Genome;
import org.springframework.stereotype.Component;


public record Photosynthesis(int heal) implements Gene {

    @Override
    public void affect(Alive owner, Genome genome) {
        owner.repaint(c -> c.remix(-heal / 128, heal / 60, -heal / 128));
        owner.heal(heal);
        genome.incrementGeneIndex(1);
    }

    @Component
    public static final class GeneFactory implements Factory<Gene> {

        private final Gene gene = new Photosynthesis(250);

        @Override
        public Gene create() {
            return gene;
        }
    }
}
