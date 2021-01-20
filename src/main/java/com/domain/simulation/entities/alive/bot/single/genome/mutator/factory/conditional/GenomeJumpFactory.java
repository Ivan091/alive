package com.domain.simulation.entities.alive.bot.single.genome.mutator.factory.conditional;

import com.domain.simulation.entities.alive.bot.single.genome.gene.Gene;
import com.domain.simulation.entities.alive.bot.single.genome.gene.conditional.GenomeJump;
import com.domain.simulation.entities.alive.bot.single.genome.mutator.factory.GeneFactory;

public class GenomeJumpFactory implements GeneFactory {
    @Override
    public Gene create(int key, int genomeLength) {
        if (genomeLength < 4) {
            key = 1;
        } else {
            key = key % (genomeLength / 4);
        }
        return new GenomeJump(key);
    }
}
