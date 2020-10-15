package alive.bot.genome;

import alive.bot.genome.gen.Gen;

public interface Genome {

    Gen getCurrentGen();

    void moveNext(int countOfGenes);
}
