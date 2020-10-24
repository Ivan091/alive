package alive.field.cell.content;

public class DeadBotBody implements CellContent {

    private int energyValue;

    /**
     *
     * @param energyValue energy value that a bot gets when it eats the dead body.
     */
    public DeadBotBody(int energyValue) {

        this.energyValue = energyValue;
    }

    @Override
    public int getEnergyValue() {

        return energyValue;
    }
}
