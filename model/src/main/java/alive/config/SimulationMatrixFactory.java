package alive.config;

import alive.entity.MatrixNavigator;
import alive.entity.Movable;
import alive.entity.cell.Cell;
import alive.entity.genome.*;
import alive.entity.genome.gene.Photosynthesis;
import alive.simulation.*;
import org.springframework.stereotype.Component;
import java.util.Arrays;


@Component
public class SimulationMatrixFactory implements SimulationFactory {

    private final Photosynthesis photoFactory;

    public SimulationMatrixFactory(Photosynthesis photoFactory) {
        this.photoFactory = photoFactory;
    }

    private Genome createDefaultGenome() {
        var genes = new Gene[20];
        Arrays.fill(genes, photoFactory.create());
        return new SequentialGenome(genes);
    }

    private Movable createAdam(Field field, Genome genome, Position position) {
        return new Cell(
                5000,
                new MatrixNavigator(
                        field,
                        position
                ),
                genome
        );
    }

    @Override
    public Simulation create(int width, int height) {
        var sim = new SimulationLive(new FieldMatrix(width, height));
        var adam = createAdam(sim, createDefaultGenome(), new PositionMatrix(width / 2, height / 2));
        adam.register();
        return sim;
    }
}
