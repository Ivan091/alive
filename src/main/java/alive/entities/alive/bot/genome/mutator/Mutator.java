package alive.entities.alive.bot.genome.mutator;

public interface Mutator<T> {

    T mutate(T mutatingItem);
}

