package com.model.simulation.entities.alive.bot.genome.mutator;

public interface Mutator<T> {

    T mutate(T mutatingItem);
}

