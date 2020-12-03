package alive.bot.genome.gene.conditional;

import alive.bot.genome.gene.Gene;

public abstract class AbstractConditionalGene implements Gene {

    /**
     * parameter for conditional jump
     */
    protected int key;

    /**
     * @param key Using as a parameter for conditional jump.
     */
    public AbstractConditionalGene(int key) {

        this.key = key;
    }

    @Override
    public boolean equals(Object obj) {

        return (obj.getClass() == this.getClass()) && ((AbstractConditionalGene) obj).key == this.key;
    }

    @Override
    public String toString() {
        return "AbstractConditionalGene{" +
                "key=" + key +
                '}';
    }
}
