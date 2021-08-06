package alive.entity.genome.gene;

import alive.entity.genome.Gene;


public abstract class GeneConditional implements Gene {

    protected final int key;

    public GeneConditional(int key) {
        this.key = key;
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName() +
                '{' +
                "key=" + key +
                '}';
    }
}
