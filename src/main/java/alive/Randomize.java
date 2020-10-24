package alive;

import java.util.Random;
import java.util.concurrent.CompletableFuture;

public abstract class Randomize {

    private static final double[] randNumbs = new double[1000];

    private static int idx;

    static {
        var rand = new Random();
        for (var i = 0; i < randNumbs.length; ++i) {
            randNumbs[i] = rand.nextDouble();
        }
    }

    public static int next(int lowerLimit, int upperLimit) {

        if (idx > randNumbs.length * 0.95) {
            CompletableFuture.runAsync(() -> {
                        var rand = new Random();
                        for (var i = 0; i < randNumbs.length; ++i) {
                            randNumbs[i] = rand.nextDouble();
                        }
                    }

            );
            idx = 0;
        }

        return (int) (randNumbs[idx++] * (upperLimit + 1 - lowerLimit) + lowerLimit);
    }
}
