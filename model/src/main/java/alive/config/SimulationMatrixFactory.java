package alive.config;

import alive.entity.MatrixNavigator;
import alive.entity.Movable;
import alive.entity.cell.Cell;
import alive.entity.genome.*;
import alive.entity.genome.gene.factory.PhotosynthesisFactory;
import alive.simulation.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import java.util.Arrays;
import java.util.function.BiFunction;


@Configuration
public class SimulationMatrixFactory {

    private final Mutator<Gene[]> mutator;

    private final PhotosynthesisFactory photoFactory;

    public SimulationMatrixFactory(Mutator<Gene[]> mutator, PhotosynthesisFactory photoFactory) {
        this.mutator = mutator;
        this.photoFactory = photoFactory;
    }

    private Genome createDefaultGenome() {
        var genes = new Gene[20];
        Arrays.fill(genes, photoFactory.get());
        return new SequentialGenome(genes, mutator);
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

    @Bean
    public BiFunction<Integer, Integer, Simulation> simulationCreator() {
        return this::create;
    }

    private Simulation create(int width, int height) {
        var simulation = new SimulationLive(new FieldMatrix(width, height));
        createAdam(simulation, createDefaultGenome(), new PositionMatrix(width / 2, height / 2)).register();
        return simulation;
    }
}
