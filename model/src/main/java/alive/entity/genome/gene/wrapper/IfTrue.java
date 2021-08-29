package alive.entity.genome.gene.wrapper;

import alive.entity.Alive;
import alive.entity.genome.Gene;
import alive.entity.genome.Genome;
import java.util.Collection;


public record IfTrue(boolean condition, Gene gene) implements Gene {

    public IfTrue(boolean condition, Gene... genes) {
        this(condition, new Sequence(genes));
    }
    
    public IfTrue(boolean condition, Collection<Gene> genes) {
        this(condition, new Sequence(genes));
    }

    @Override
    public void affect(Alive owner, Genome genome) {
        if (condition) {
            gene.affect(owner, genome);
        }
    }
}
