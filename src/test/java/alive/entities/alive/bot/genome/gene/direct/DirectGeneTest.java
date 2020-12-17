package alive.entities.alive.bot.genome.gene.direct;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class DirectGeneTest {

    @Test
    void testEquals() {
        Assertions.assertEquals(new Photosynthesis(), new Photosynthesis());
        Assertions.assertNotEquals(new Photosynthesis(), new Go());
    }
}