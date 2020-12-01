package alive.field.cells.content;

public class Empty implements Content {

    @Override
    public void eraseFromField() {

    }

    @Override
    public int getEnergyValue() {

        return 0;
    }

    @Override
    public boolean equals(Object obj) {
        return this.getClass() == obj.getClass();
    }
}
