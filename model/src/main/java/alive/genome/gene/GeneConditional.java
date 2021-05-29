package alive.genome.gene;

public abstract class GeneConditional extends GeneBasic {

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
