package alive.genome;

import alive.entity.Alive;
import org.springframework.stereotype.Component;


@Component
public final class Photosynthesis extends GeneBasic {

    @Override
    public void affect(Alive alive, Genome genome) {
        alive.heal(10);
        genome.incrementGeneIndex(1);
    }
}
