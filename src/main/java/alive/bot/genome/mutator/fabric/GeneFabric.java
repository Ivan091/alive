package alive.bot.genome.mutator.fabric;

import alive.bot.genome.gene.Gene;
import alive.bot.genome.gene.conditional.ConditionalGene;

/**
 * Fabric for {@link Gene}.
 */
public interface GeneFabric {

    /**
     * Creates new gene.
     *
     * @param key necessary to create {@link ConditionalGene}.
     * @return create gene.
     */
    Gene create(int key);
}
