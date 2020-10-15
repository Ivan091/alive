package alive.bot.model;


import alive.Field;

public interface Movable {

    /**
     * Calls when alive.bot should make a move.
     *
     * @param field main field
     */
    void makeAMove(Field field);
}

