package alive.genome;

import java.util.Random;


public abstract class GeneConditional extends GeneBasic {

    protected int key = new Random().nextInt(256);

    @Override
    public String toString() {
        return this.getClass().getSimpleName() +
                '{' +
                "key=" + key +
                '}';
    }
}
