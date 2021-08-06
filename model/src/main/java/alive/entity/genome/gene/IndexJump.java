package alive.entity.genome.gene;

import alive.entity.Alive;
import alive.entity.genome.Genome;


public final class IndexJump extends GeneConditional {

    public IndexJump(int key) {
        super(key);
    }

    @Override
    public void affect(Alive alive, Genome genome) {
        genome.incrementGeneIndex(key);
        genome.affect(alive);
    }
}
