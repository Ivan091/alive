package alive.bot.genome.mutator.fabric;

import alive.bot.genome.gene.Gene;
import alive.bot.genome.gene.conditional.AbstractConditionalGene;

/**
 * Fabric for {@link Gene}.
 */
public interface GeneFabric {

    /**
     * Creates new gene.
     * @param key necessary to create {@link AbstractConditionalGene}.
     * @return create gene.
     */
    Gene create(int key);
}
