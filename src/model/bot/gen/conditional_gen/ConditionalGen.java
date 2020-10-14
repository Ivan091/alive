package model.bot.gen.conditional_gen;

import model.bot.gen.IGen;

public abstract class ConditionalGen implements IGen {

    /**
     * parameter for conditional jump
     */
    protected int key;

    /**
     * @param key Using as a parameter for conditional jump.
     *
     */
    public ConditionalGen(int key) {

        this.key = key;
    }

    @Override
    public boolean equals(Object obj) {
        return (obj.getClass() == this.getClass()) && ((ConditionalGen)obj).key == this.key;
    }
}
