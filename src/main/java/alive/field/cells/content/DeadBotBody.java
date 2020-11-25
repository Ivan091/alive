package alive.field.cells.content;

public class DeadBotBody implements Content {

    private final int energyValue;

    /**
     * @param energyValue energy value that a bot gets when it eats the dead body.
     */
    public DeadBotBody(int energyValue) {

        this.energyValue = energyValue;
    }

    @Override
    public void eraseFromField() {

    }

    @Override
    public int getEnergyValue() {

        return energyValue;
    }
}
