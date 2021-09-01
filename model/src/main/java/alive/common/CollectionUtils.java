package alive.common;

import java.util.List;
import java.util.Random;


public class CollectionUtils {

    private static final Random random = new Random();

    public static <T> T getRandom(List<T> list) {
        return list.get(random.nextInt(list.size()));
    }

    public static <T> T getRandom(T[] array) {
        return array[random.nextInt(array.length)];
    }

    public static int makeLoopedInside(int index, Object[] array) {
        return makeLoopedInside(index, array.length);
    }

    public static int makeLoopedInside(int index, int length) {
        if (index < 0) return index + length;
        if (index >= length) return index - length;
        return index;
    }
}
