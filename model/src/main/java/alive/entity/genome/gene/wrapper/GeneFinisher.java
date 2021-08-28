package alive.entity.genome.gene.wrapper;

import alive.entity.Alive;
import alive.entity.genome.Gene;
import alive.entity.genome.Genome;


public record GeneFinisher(Gene gene, int heal, int increment, boolean isRecursive) implements Gene {

    @Override
    public void affect(Alive owner, Genome genome) {
        gene.affect(owner, genome);
        owner.heal(heal);
        genome.incrementGeneIndex(increment);
        if (isRecursive) {
            genome.affect(owner);
        }
    }
}
