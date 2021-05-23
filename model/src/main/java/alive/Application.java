package alive;

import alive.factories.CellHealthFactory;
import alive.field.Hollow;
import alive.field.matrix.*;
import alive.organic.cell.Cell;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
        var field = new FieldMatrix(100, 100, new Hollow());
        var c = new Cell(
                new NavigatorMatrix(
                        field,
                        new DirectionInspectorMatrix(
                                0,
                                new DirectionMatrixModifier()),
                        new PositionMatrix(0, 0)),
                new CellHealthFactory(100));
    }
}
