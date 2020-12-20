package alive.entities.alive.bot.genome.mutator.fabric;

import alive.entities.alive.bot.genome.gene.Gene;
import alive.entities.alive.bot.genome.gene.conditional.ConditionalGene;

/**
 * Fabric for {@link Gene}.
 */
public interface GeneFactory {

    /**
     * Creates new gene.
     *
     * @param key          necessary to create {@link ConditionalGene}.
     * @param genomeLength
     * @return create gene.
     */
    Gene create(int key, int genomeLength);
}
