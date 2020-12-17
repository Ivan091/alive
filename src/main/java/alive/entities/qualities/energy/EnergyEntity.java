package alive.entities.qualities.energy;

public class EnergyEntity implements Energy {

    protected int energyValue;

    public EnergyEntity(int energyValue) {
        this.energyValue = energyValue;
    }

    public EnergyEntity(Energy energy) {
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
