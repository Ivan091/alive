package alive.bot.genome;

import alive.bot.genome.gene.Gene;
import alive.bot.model.Bot;

public interface Genome extends Replicable<Genome> {

    /**
     * Genome is infinite looped sequence of genes,
     * so the index cannot be out of range.
     *
     * @param increment can be any negative or positive int.
     */
    void incrementGeneIdx(int increment);

    boolean runCurrentGene(Bot bot);

    Gene getCurrentGene();

    int length();
}
