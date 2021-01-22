package com.domain.simulation.entities.visitor;

import com.domain.simulation.entities.Entity;
import com.domain.simulation.entities.alive.bot.Bot;
import com.domain.simulation.entities.lifeless.Empty;

public interface Visitor {
    void visit(Empty empty);

    void visit(Bot bot);

    void visit(Entity entity);
}
