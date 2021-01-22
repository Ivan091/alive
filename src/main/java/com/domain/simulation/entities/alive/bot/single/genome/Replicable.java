package com.domain.simulation.entities.alive.bot.single.genome;

/**
 * Implemented by each class that is replicated during the replication of the bot.
 *
 * @param <T> class which is replicating.
 */
public interface Replicable<T> {

    /**
     * Calls during the bot replication.
     *
     * @return new replicated object.
     */
    T replicate();
}