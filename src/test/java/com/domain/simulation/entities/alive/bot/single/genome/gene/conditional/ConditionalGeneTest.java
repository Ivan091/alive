package com.domain.simulation.entities.alive.bot.single.genome.gene.conditional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ConditionalGeneTest {

    @Test
    void testEquals() {

        Assertions.assertEquals(new Rotating(10), new Rotating(10));
        Assertions.assertNotEquals(new Rotating(10), new Rotating(9));
        Assertions.assertNotEquals(new GenomeJump(10), new Rotating(10));
        Assertions.assertNotEquals(new GenomeJump(10), new Rotating(9));
    }
}