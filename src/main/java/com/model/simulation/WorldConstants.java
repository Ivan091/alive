package com.model.simulation;

public final class WorldConstants {

    /**
     * Maximal energy value. If bot has more, it is replicated immediately.
     */
    public static final int MAX_ENERGY_VALUE = 1000;

    /**
     * Minimal energy value. If bot has less, it is destroyed immediately.
     */
    public static final int MIN_ENERGY_VALUE = 1;


    /**
     * When bot dies he leave it's dead body on the field. The body is eatable entity.
     * If another bot eats the dried body, it get the value as additional reward.
     */
    public static final int DRIED_BODY_ENERGY_VALUE = 300;

    public static final int GENE_REPLICATION_COST = 10;

    /**
     * The cost of using each gene.
     */
    public static final int BOT_RUN_GENE_ENERGY_INCREMENT = -3;

    /**
     * How many genes can each bot use during one move.
     */
    public static final int BOT_MAX_GENES_PER_MOVE = 10;

    /**
     * Genome length of first bot. Genome length can be changed during simulation for any bot separately.
     */
    public static final int GENOME_LENGTH = 16;

    /**
     * Probability of mutation during replication of bot.
     */
    public static final double MUTATION_PROBABILITY = 0.25;
}
