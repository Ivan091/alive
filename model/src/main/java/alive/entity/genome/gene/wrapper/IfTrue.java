package alive.entity.genome.gene.wrapper;

import alive.entity.Alive;
import alive.entity.genome.Gene;
import alive.entity.genome.Genome;
import java.util.Collection;
import java.util.List;


public record IfTrue(boolean condition, Collection<Gene> genes) implements Gene {

    public IfTrue(boolean condition, Gene... genes) {
        this(condition, List.of(genes));
    }

    @Override
    public void affect(Alive owner, Genome genome) {
        if (condition) {
            for (var gene : genes) {
                gene.affect(owner, genome);
            }
        }
    }
}
