package alive.bot.energy;

import alive.bot.model.mortal.Mortal;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class BotEnergyTest {

    private Mortal testBot = new Mortal() {
        @Override
        public void Replicate() {

        }

        @Override
        public void Destroy() {

        }
    };


    @Test
    void changeEnergyValue() {

        var num = 1;
        var energy = new BotEnergy(testBot, num);


        energy.changeEnergyValue(10);
        num += 10;

        Assertions.assertEquals(num, energy.getEnergyValue());

        energy.changeEnergyValue(-123);
        num -= 123;

        Assertions.assertEquals(num, energy.getEnergyValue());

        energy.changeEnergyValue(0);

        Assertions.assertEquals(num, energy.getEnergyValue());
    }
}