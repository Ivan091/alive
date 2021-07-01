package alive.config;

import alive.entity.Entity;
import alive.entity.Movable;
import alive.entity.cell.*;
import alive.entity.genome.Gene;
import alive.entity.genome.Genome;
import alive.entity.genome.gene.Photosynthesis;
import alive.simulation.*;
import org.springframework.aop.target.PrototypeTargetSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.*;
import java.util.HashMap;


@Configuration
public class Config implements SimulationFieldFactory {

    @Bean
    SimulationsHolder createHolder(){
        return new SimulationsFieldHolder(new HashMap<>(), 0);
    }

    @Bean
    @Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
    SimulationField field(Movable adam) {
        adam.register();
        return createSimulation(200, 100);
    }

    @Bean
    @Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
    Genome defaultGenome() {
        var genes = new Gene[64];
        for (int i = 0; i < genes.length; i++) {
            genes[i] = new Photosynthesis();
        }
        return new CellGenome(genes);
    }

    @Bean
    @Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
    Movable createAdam(Field field, Genome genome) {
        return new Cell(
                200,
                new CellNavigator(
                        field,
                        new PositionMatrix(0, 0)
                ),
                genome
        );
    }

    @Override
    @Autowired(required = false)
    public SimulationField createSimulation(int width, int height) {
        var matrix = new Entity[width][height];
        var empty = new Empty();
        for (var i = 0; i < matrix.length; i++) {
            for (var j = 0; j < matrix[0].length; j++) {
                matrix[i][j] = empty;
            }
        }
        return new SimulationLive(new FieldMatrix(matrix, empty));
    }
}
