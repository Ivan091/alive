package alive;

import java.util.Random;
import java.util.concurrent.CompletableFuture;

public abstract class Randomize {

    private static final float[] randNumbs = new float[1000];

    private static int idx;

    static {
        reRandomize();
    }

    /**
     *
     * @param lowerLimit lower randomization limit
     * @param upperLimit upper randomization limit (not including)
     * @return random int from [lowerLimit, upperLimit).
     */

    public static int nextInt(int lowerLimit, int upperLimit) {

        incrementIdx();

        return (int) (randNumbs[idx] * (upperLimit - lowerLimit) + lowerLimit);
    }

    /**
     *
     * @param upperLimit upper randomization limit.
     * @return random int number from [0, upperLimit).
     */
    public static int nextInt(int upperLimit) {

        return nextInt(0, upperLimit);
    }

    /**
     *
     * @return random float from [0.0, 1.0).
     */
    public static float nextFloat() {

        incrementIdx();

        return randNumbs[idx];
    }

    private static void incrementIdx() {

        if (idx > randNumbs.length * 0.95) {
            CompletableFuture.runAsync(Randomize::reRandomize);
            idx = 0;
        } else {
            ++idx;
        }
    }

    private static void reRandomize() {

        var rand = new Random();
        for (var i = 0; i < randNumbs.length; ++i) {
            randNumbs[i] = rand.nextFloat();
        }
    }
}
