package alive.config;

import alive.field.Field;


public interface FieldFactory {

    Field createFieldMatrix(int width, int height);
}
