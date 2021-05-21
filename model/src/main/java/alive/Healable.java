package alive;

import java.util.function.Function;


public interface Healable {

    void heal(Function<Integer, Integer> health);
}
