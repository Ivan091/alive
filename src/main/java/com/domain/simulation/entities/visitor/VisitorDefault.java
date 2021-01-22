package com.domain.simulation.entities.visitor;

import com.domain.simulation.entities.alive.bot.Bot;
import com.domain.simulation.entities.lifeless.Empty;
import com.domain.simulation.entities.lifeless.LifelessBody;

public abstract class VisitorDefault<T> implements Visitor, Respondent<T> {

    private final T defaultValue;
    protected T response;

    public VisitorDefault(T defaultValue) {
        this.defaultValue = defaultValue;
        response = defaultValue;
    }

    @Override
    public void visit(Bot bot) {
        response = defaultValue;
    }

    @Override
    public void visit(LifelessBody body) {
        response = defaultValue;
    }

    @Override
    public void visit(Empty empty) {
        response = defaultValue;
    }
}
