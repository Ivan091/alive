package alive.genome.gene;

import alive.entity.Alive;
import alive.genome.Genome;
import org.springframework.stereotype.Component;


@Component
public final class IndexJump extends GeneConditional {

    @Override
    public void affect(Alive alive, Genome genome) {
        genome.incrementGeneIndex(key);
        genome.affect(alive);
    }
}
