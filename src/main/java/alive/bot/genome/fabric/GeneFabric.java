package alive.bot.genome.fabric;

import alive.bot.genome.gene.Gene;

/**
 * Fabric for {@link Gene}.
 */
public interface GeneFabric {

    /**
     * Creates new gene.
     * @param key necessary to create {@link alive.bot.genome.gene.conditional.ConditionalGene}.
     * @return create gene.
     */
    Gene create(int key);
}
