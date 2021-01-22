package com.domain.simulation.entities.visitor;

import com.domain.simulation.entities.alive.bot.Bot;

public interface VisitorFriendly extends
        Visitor,
        Assignable<Bot>,
        Respondent<Boolean> {
}
