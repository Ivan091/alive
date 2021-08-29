package alive.entity.genome.gene.command;

import alive.entity.Alive;
import alive.entity.genome.Gene;
import alive.entity.genome.Genome;


public record GeneSequence(Gene... genes) implements Gene {

    @Override
    public void affect(Alive owner, Genome genome) {
        for (var gene : genes) {
            gene.affect(owner, genome);
        }
    }

    @Override
    public void affect(Alive owner) {
        for (var gene : genes) {
            gene.affect(owner);
        }
    }
}
