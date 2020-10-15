package alive.bot.genome.gen.conditional;

import alive.bot.genome.gen.Gen;

public abstract class ConditionalGen implements Gen {

    /**
     * parameter for conditional jump
     */
    protected int key;

    /**
     * @param key Using as a parameter for conditional jump.
     */
    public ConditionalGen(int key) {

        this.key = key;
    }

    @Override
    public boolean equals(Object obj) {

        return (obj.getClass() == this.getClass()) && ((ConditionalGen) obj).key == this.key;
    }
}
