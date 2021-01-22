package com.domain.simulation.entities.alive.bot.single.genome;

import com.domain.simulation.WorldConstants;
import com.domain.simulation.entities.alive.bot.single.genome.gene.Gene;
import com.domain.simulation.entities.alive.bot.single.genome.gene.direct.Photosynthesis;

import java.util.stream.IntStream;

public class GenomeBuilder {
    public Genome buildDefault() {
        var genes = new Gene[WorldConstants.GENOME_LENGTH];

        IntStream.range(0, genes.length).forEach(i -> genes[i] = new Photosynthesis());

        return new GenomeBot(genes);
    }
}
