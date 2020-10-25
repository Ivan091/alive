package alive.bot.energy;

import java.util.function.Function;

public interface Energy {

    int getEnergyValue();

    void setEnergyValue(int newValue);

    void changeEnergyValue(int changing);

    void changeEnergyValue(Function<Integer, Integer> function);
}
