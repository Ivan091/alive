package alive.genome;

import alive.entity.Alive;
import org.springframework.stereotype.Component;


@Component
public final class IndexJump extends GeneConditional {

    @Override
    public void affect(Alive alive, Genome genome) {
        genome.incrementGeneIndex(key);
        genome.affect(alive);
    }
}
