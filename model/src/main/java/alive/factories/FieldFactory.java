package alive.factories;

import alive.field.Field;


public interface FieldFactory {

    Field create(int width, int height);
}
