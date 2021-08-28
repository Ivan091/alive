package alive.common;

public class ArrayUtils {

    public static int makeInside(int index, Object[] array) {
        return makeInside(index, array.length);
    }

    public static int makeInside(int index, int length) {
        if (index < 0) return index + length;
        if (index >= length) return index - length;
        return index;
    }
}
