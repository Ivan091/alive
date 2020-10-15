package alive.bot.genome;

import alive.bot.genome.gen.Gen;

public interface Genome {

    Gen getCurrentGen();

    /**
     * Genome is infinite looped sequence of genes,
     * so index cannot be out of range.
     *
     * @param increment can be any negative or positive number.
     */
    void incrementGenIdx(int increment);
}
