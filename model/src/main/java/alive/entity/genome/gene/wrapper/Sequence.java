package alive.entity.genome.gene.wrapper;

import alive.entity.Alive;
import alive.entity.genome.Gene;
import alive.entity.genome.Genome;
import java.util.Collection;
import java.util.List;


public record Sequence(Collection<Gene> genes) implements Gene {

    public Sequence(Gene... genes) {
        this(List.of(genes));
    }

    @Override
    public void affect(Alive owner, Genome genome) {
        for (var gene : genes) {
            gene.affect(owner, genome);
        }
    }
}
