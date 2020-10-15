package alive.bot.genome;

import alive.bot.genome.gen.Gen;
import alive.bot.genome.gen.direct.Photosynthesis;

public class BotGenome implements Genome {

    private final Gen[] genes;

    private int currentGenIdx;

    public BotGenome(int genomeLength) {

        genes = new Gen[genomeLength];
        for (var i = 0; i < genomeLength; ++i) {
            genes[i] = new Photosynthesis();
        }
    }

    @Override
    public Gen getCurrentGen() {

        return genes[currentGenIdx];
    }

    @Override
    public void moveNext(int countOfGenes) {

        currentGenIdx = (currentGenIdx + countOfGenes) % genes.length;
    }
}
