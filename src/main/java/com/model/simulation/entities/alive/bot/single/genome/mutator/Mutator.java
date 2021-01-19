package com.model.simulation.entities.alive.bot.single.genome.mutator;

public interface Mutator<T> {

    T mutate(T mutatingItem);
}

