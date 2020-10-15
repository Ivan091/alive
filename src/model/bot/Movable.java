package model.bot;

import model.Field;

public interface Movable {

    /**
     * Calls when bot should make a move.
     *
     * @param field main field
     */
    void makeAMove(Field field);
}

