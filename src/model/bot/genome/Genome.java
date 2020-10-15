package model.bot.genome;

import model.bot.genome.gen.Gen;

public interface Genome {

    Gen getCurrentGen();

    void moveNext(int countOfGenes);
}
