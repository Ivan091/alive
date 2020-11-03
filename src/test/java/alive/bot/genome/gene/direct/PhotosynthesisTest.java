package alive.bot.genome.gene.direct;

import alive.bot.genome.gene.*;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class PhotosynthesisTest {

    Gene photo = new Photosynthesis();

    @BeforeAll
    public static void isGenomeIncrementCalled() {

        GeneTest.isGenomeIncrementCalled(new Photosynthesis());
    }

    @Test
    void replicate() {

        var photo2 = photo.replicate();

        assertEquals(photo, photo.replicate());
    }
}