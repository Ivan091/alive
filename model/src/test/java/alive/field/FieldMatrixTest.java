package alive.field;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


class FieldMatrixTest {

    FieldMatrix fieldMatrix = new FieldMatrix(2, 2);

    @Test
    void checksIfIsInBounds() {
        assertTrue(fieldMatrix.isInBounds(new PositionMatrix(1, 1)));
        assertTrue(fieldMatrix.isInBounds(new PositionMatrix(0, 0)));
        assertFalse(fieldMatrix.isInBounds(new PositionMatrix(2, 2)));
        assertFalse(fieldMatrix.isInBounds(new PositionMatrix(0, 2)));
    }
}