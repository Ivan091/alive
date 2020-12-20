package alive.entities.alive.bot.genome.mutator.fabric.direct;

import alive.entities.alive.bot.genome.gene.Gene;
import alive.entities.alive.bot.genome.gene.direct.Photosynthesis;
import alive.entities.alive.bot.genome.mutator.fabric.GeneFactory;

public class PhotosynthesisGeneFactory implements GeneFactory {

    @Override
    public Gene create(int key, int genomeLength) {

        return new Photosynthesis();
    }
}
