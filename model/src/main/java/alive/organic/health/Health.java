package alive.organic.health;

import java.util.function.Function;


public interface Health {

    void heal(Function<Integer, Integer> healthModifier);

    Integer health();
}
