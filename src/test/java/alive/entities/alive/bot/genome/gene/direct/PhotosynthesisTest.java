package alive.entities.alive.bot.genome.gene.direct;

import alive.entities.alive.bot.genome.gene.GeneTest;
import alive.entities.alive.bot.genome.mutator.fabric.direct.PhotosynthesisGeneFactory;

class PhotosynthesisTest extends GeneTest {

    public PhotosynthesisTest() {
        super(new PhotosynthesisGeneFactory().create(0, 0));
    }
}