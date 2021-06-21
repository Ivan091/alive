package alive.entity.genome.gene;

import alive.entity.Alive;
import alive.entity.genome.Genome;
import org.springframework.stereotype.Component;
import java.util.Random;


@Component
public final class IndexJump extends GeneConditional {

    public IndexJump() {
        super(new Random().nextInt(8) + 1);
    }

    @Override
    public void affect(Alive alive, Genome genome) {
        genome.incrementGeneIndex(key);
        genome.affect(alive);
    }
}
