package alive.config;

import alive.entity.Movable;
import alive.entity.cell.*;
import alive.entity.genome.Gene;
import alive.entity.genome.Genome;
import alive.entity.genome.gene.Photosynthesis;
import alive.simulation.*;
import org.springframework.stereotype.Component;


@Component
public class SimulationMatrixFactory implements SimulationFactory {

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
        var sim = new SimulationLive(new FieldMatrix(width, height));
        var adam = createAdam(sim, defaultGenome());
        adam.register();
        return sim;
    }
}
