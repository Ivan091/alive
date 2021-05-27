package alive;

import alive.entity.Alive;
import alive.entity.Entity;
import alive.entity.cell.*;
import alive.genome.*;
import alive.simulation.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class Config {

    @Bean
    SimulationField field() {
        var matrix = new Entity[200][100];
        var empty = new Empty();
        for (var i = 0; i < matrix.length; i++) {
            for (var j = 0; j < matrix[0].length; j++) {
                matrix[i][j] = empty;
            }
        }
        return new SimulationLive(new FieldMatrix(matrix, empty));
    }

    @Bean
    Genome defaultGenome() {
        var genes = new Gene[64];
        for (int i = 0; i < genes.length; i++) {
            genes[i] = new Photosynthesis();
        }
        return new CellGenome(genes);
    }

    @Bean
    Alive createAdam(Field field, Genome genome) {
        return new Cell(
                200,
                new CellNavigator(
                        field,
                        new PositionMatrix(0, 0)
                ),
                genome
        );
    }
}
