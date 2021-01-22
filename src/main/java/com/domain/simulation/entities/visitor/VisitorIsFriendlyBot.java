package com.domain.simulation.entities.visitor;

import com.domain.simulation.entities.Entity;
import com.domain.simulation.entities.alive.bot.Bot;

public class VisitorIsFriendlyBot extends VisitorDefault<Boolean> implements Visitor {

    private final Bot bot;

    public VisitorIsFriendlyBot(Bot bot) {
        super(false);
        this.bot = bot;
    }

    @Override
    public void visit(Bot otherBot) {
        response = this.bot.isFriendly(otherBot);
    }

    @Override
    public Boolean response(Entity entity) {
        entity.accept(this);
        return response;
    }
}
