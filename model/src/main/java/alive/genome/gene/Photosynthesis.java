package alive.genome.gene;

import alive.entity.Alive;
import alive.genome.Genome;
import org.springframework.stereotype.Component;


@Component
public final class Photosynthesis extends GeneBasic {

    @Override
    public void affect(Alive alive, Genome genome) {
        alive.heal(20);
        genome.incrementGeneIndex(1);
    }
}
