package alive.bot;

import alive.Healable;
import java.util.function.Function;


public class Health implements Healable {

    Integer health;

    public Health(Integer initHealth) {
        health = initHealth;
    }

    @Override
    public void heal(Function<Integer, Integer> healthModifier) {
        health = healthModifier.apply(health);
    }

    @Override
    public Integer health() {
        return health;
    }
}
