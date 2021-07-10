package alive.config;

import alive.entity.Entity;
import alive.entity.Movable;
import alive.entity.cell.*;
import alive.entity.genome.Gene;
import alive.entity.genome.Genome;
import alive.entity.genome.gene.Photosynthesis;
import alive.simulation.*;
import org.springframework.stereotype.Component;


@Component
public class SimulationMatrixFactory implements SimulationFactory{

    private Genome defaultGenome() {
        var genes = new Gene[64];
        for (int i = 0; i < genes.length; i++) {
            genes[i] = new Photosynthesis();
        }
        return new CellGenome(genes);
    }

    private Movable createAdam(Field field, Genome genome) {
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
    public Simulation create(int width, int height) {
        var matrix = new Entity[width][height];
        var empty = new Empty();
        for (var i = 0; i < matrix.length; i++) {
            for (var j = 0; j < matrix[0].length; j++) {
                matrix[i][j] = empty;
            }
        }
        var sim =  new SimulationLive(new FieldMatrix(matrix, empty));
        var adam = createAdam(sim, defaultGenome());
        adam.register();
        return sim;
    }
}
