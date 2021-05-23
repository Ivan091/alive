package alive.factories;

import alive.field.*;
import alive.organic.Alive;
import alive.organic.cell.Cell;
import alive.organic.cell.CellHealth;
import alive.organic.health.HealthBasic;


public class CellFactory implements Factory<Alive> {

    private final Field field;

    public CellFactory(Factory<Field> fieldFactory) {
        field = fieldFactory.create();
    }

    @Override
    public Alive create() {
        return
                new Cell(
                        new Navigator(
                                field,
                                new DirectionInspectorMatrix(
                                        0,
                                        new DirectionMatrixModifier()
                                ),
                                new PositionMatrix(0, 0)
                        ),
                        new CellHealth(
                                new HealthBasic(100)
                        )
                );
    }
}
