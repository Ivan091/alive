package alive.entity.genome.gene.wrapper;

import alive.entity.Alive;
import alive.entity.genome.Gene;
import alive.entity.genome.Genome;


public record Sequence(Gene... genes) implements Gene {

    @Override
    public void affect(Alive owner, Genome genome) {
        for (var gene : genes) {
            gene.affect(owner, genome);
        }
    }
}
