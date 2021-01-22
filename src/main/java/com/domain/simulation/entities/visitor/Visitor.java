package com.domain.simulation.entities.visitor;

import com.domain.simulation.entities.alive.bot.Bot;
import com.domain.simulation.entities.lifeless.Empty;
import com.domain.simulation.entities.lifeless.LifelessBody;

public interface Visitor {
    void visit(Bot bot);

    void visit(LifelessBody body);

    void visit(Empty empty);
}
