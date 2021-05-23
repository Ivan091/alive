package alive.factories;

import alive.field.*;


public class FieldMatrixFactory implements Factory<Field> {

    @Override
    public Field create() {
        return new FieldMatrix(100, 100, new Hollow());
    }
}
