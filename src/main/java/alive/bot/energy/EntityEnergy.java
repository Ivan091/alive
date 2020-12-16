package alive.bot.energy;

public class EntityEnergy implements Energy {

    protected int energyValue;

    public EntityEnergy(int energyValue) {
        this.energyValue = energyValue;
    }

    public EntityEnergy(Energy energy) {
        energyValue = energy.getEnergyValue();
    }

    @Override
    public int getEnergyValue() {
        return energyValue;
    }

    @Override
    public void setEnergyValue(int newValue) {

        energyValue = newValue;
    }
}
