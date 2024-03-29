package alive.fx;

import alive.entity.Entity;
import alive.simulation.Simulation;
import javafx.animation.PauseTransition;
import javafx.scene.canvas.Canvas;
import javafx.scene.paint.Color;
import javafx.util.Duration;
import org.springframework.stereotype.Component;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.function.BiFunction;


@Component
public class FieldMatrix extends Canvas {

    private static final int W = 317;

    private static final int H = 165;

    private static final int SIZE = 6;

    private final Simulation simulation;

    public FieldMatrix(BiFunction<Integer, Integer, Simulation> simulationFactory) {
        simulation = simulationFactory.apply(W, H);
        setWidth(W * SIZE);
        setHeight(H * SIZE);
    }

    public void simulate() {
        Executors.newScheduledThreadPool(4).scheduleAtFixedRate(simulation::update, 1000, 1, TimeUnit.MICROSECONDS);
        createCanvasUpdateCycle().play();
    }

    private void mapStateToCanvas(Entity[][] state) {
        var gc = getGraphicsContext2D();
        for (var i = 0; i < state.length; i++) {
            for (var j = 0; j < state[i].length; j++) {
                var entityColor = state[i][j].color();
                gc.setFill(Color.rgb(entityColor.r(), entityColor.g(), entityColor.b()));
                gc.fillRect(j * SIZE, i * SIZE, SIZE, SIZE);
            }
        }
    }

    private PauseTransition createCanvasUpdateCycle() {
        PauseTransition pause = new PauseTransition(Duration.millis(20));
        pause.setOnFinished(
                e -> {
                    mapStateToCanvas(simulation.state());
                    pause.playFromStart();
                });
        return pause;
    }
}
