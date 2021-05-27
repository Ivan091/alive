package alive;

import alive.entity.Alive;
import alive.entity.cell.Cell;
import alive.entity.cell.CellMatrixNavigator;
import alive.genome.*;
import alive.simulation.*;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class CellConfig {

    @Bean
    Field fieldMatrix() {
        return new FieldMatrix(100, 200);
    }

    @Bean
    Gene[] defaultGenes() {
        var genes = new Gene[64];
        for (int i = 0; i < genes.length; i++) {
            genes[i] = new Photosynthesis();
        }
        return genes;
    }

    @Bean
    Alive createAdam(@Qualifier("simulationLive") Field field, Genome genome) {
        var cell = new Cell(
                200,
                new CellMatrixNavigator(
                        field,
                        new PositionMatrix(0, 0)
                ),
                genome
        );
        field.place(cell, new PositionMatrix(0, 0));
        return cell;
    }
}
