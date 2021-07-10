package alive.entity.genome.gene;

import alive.entity.Alive;
import alive.entity.genome.Genome;
import org.springframework.stereotype.Component;


@Component
public final class Photosynthesis extends GeneBasic {

    @Override
    public void affect(Alive alive, Genome genome) {
        alive.heal(20);
        alive.repaint(c -> c.remix(-10, 20, -10));
        genome.incrementGeneIndex(1);
    }
}
