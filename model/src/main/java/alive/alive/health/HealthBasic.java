package alive.alive.health;

import java.util.function.Function;


public class HealthBasic implements Health {

    private Integer health;

    public HealthBasic(Integer health) {
        this.health = health;
    }

    @Override
    public void heal(Function<Integer, Integer> healthModifier) {
        health = healthModifier.apply(health);
    }

    @Override
    public Integer health() {
        return health;
    }

    @Override
    public Health reproduce() {
        health >>= 1;
        return new HealthBasic(health);
    }
}
