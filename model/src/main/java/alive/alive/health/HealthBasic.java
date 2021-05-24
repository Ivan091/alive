package alive.alive.health;

import java.util.function.Function;


public class HealthBasic implements Healable {

    Integer health;

    public HealthBasic(Integer initHealth) {
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
