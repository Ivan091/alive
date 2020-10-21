package alive.bot.genome;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertSame;

class BotGenomeTest {

    @Test
    void incrementGenIdx() {

        var genome = new BotGenome(5);

        var gen0 = genome.getCurrentGen();

        genome.incrementGenIdx(100);

        assertSame(gen0, genome.getCurrentGen());

        genome.incrementGenIdx(1);
        genome.incrementGenIdx(-1);

        assertSame(gen0, genome.getCurrentGen());

        genome.incrementGenIdx(-4);
        genome.incrementGenIdx(4);

        assertSame(gen0, genome.getCurrentGen());
    }
}