package com.Model.Bot;

import com.Model.Field;

public interface IBot {
    /**
     * Calls once when field updates.
     * @param field
     */
    void makeAMove(Field field);
}
