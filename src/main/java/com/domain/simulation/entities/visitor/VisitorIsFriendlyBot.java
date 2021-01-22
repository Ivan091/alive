package com.domain.simulation.entities.visitor;

import com.domain.simulation.entities.Entity;
import com.domain.simulation.entities.alive.bot.Bot;
import com.domain.simulation.entities.lifeless.Empty;

public class VisitorIsFriendlyBot implements VisitorFriendly {

    private Bot bot;
    private Boolean response;

    @Override
    public void visit(Empty empty) {
        response = false;
    }

    @Override
    public void visit(Bot bot) {
        response = this.bot.isFriendly(bot);
    }

    @Override
    public void visit(Entity entity) {
        response = false;
    }

    @Override
    public void assign(Bot newBot) {
        bot = newBot;
    }

    @Override
    public Boolean response() {
        return response;
    }
}
