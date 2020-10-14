package model.bot;

import model.Field;

public interface IBotMakeAMove {
    /**
     * Calls when bot should make a move.
     * @param field
     */
    void makeAMove(Field field);
}

