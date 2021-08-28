package alive.common;

public class ArrayUtils {

    public static int makeLoopedInside(int index, Object[] array) {
        return makeLoopedInside(index, array.length);
    }

    public static int makeLoopedInside(int index, int length) {
        if (index < 0) return index + length;
        if (index >= length) return index - length;
        return index;
    }
}
