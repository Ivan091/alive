package alive.bot.genome.mutator.fabric.direct;

import alive.bot.genome.gene.Gene;
import alive.bot.genome.gene.direct.Photosynthesis;
import alive.bot.genome.mutator.fabric.GeneFabric;

public class PhotosynthesisGeneFabric implements GeneFabric {

    @Override
    public Gene create(int key) {

        return new Photosynthesis();
    }
}
