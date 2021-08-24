package alive.fx;

import alive.FxApplication;
import alive.config.SimulationFactory;
import alive.entity.Entity;
import alive.simulation.Simulation;
import javafx.animation.PauseTransition;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.util.Duration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.stereotype.Component;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;


@Component
public class MainScene extends Application {

    private static final int W = 190 * 2;

    private static final int H = 100 * 2;

    private static final int size = 10 / 2;

    @Autowired
    private SimulationFactory simulationFactory;

    private ConfigurableApplicationContext applicationContext;

    @Override
    public void init() {
        applicationContext = new SpringApplicationBuilder(FxApplication.class)
                .web(WebApplicationType.NONE)
                .run();
        applicationContext
                .getAutowireCapableBeanFactory()
                .autowireBean(this);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Alive");
        primaryStage.setIconified(false);
        primaryStage.setResizable(false);
        var canvas = new Canvas(W * size, H * size);
        var scene = new Scene(new Group(canvas));
        primaryStage.setScene(scene);
        primaryStage.show();
        simulate(simulationFactory.create(W, H), canvas);
    }

    @Override
    public void stop() {
        applicationContext.stop();
        Platform.exit();
    }

    private void simulate(Simulation simulation, Canvas canvas) {
        var gc = canvas.getGraphicsContext2D();
        Executors.newScheduledThreadPool(6).scheduleWithFixedDelay(simulation::update, 100000, 4, TimeUnit.MICROSECONDS);
        PauseTransition pause = new PauseTransition(Duration.millis(20));
        pause.setOnFinished(
                e -> {
                    mapStateToCanvas(simulation.state(), gc);
                    pause.playFromStart();
                });
        pause.play();
    }

    private void mapStateToCanvas(Entity[][] state, GraphicsContext gc) {
        for (var i = 0; i < state.length; i++) {
            for (var j = 0; j < state[i].length; j++) {
                var entityColor = state[i][j].color();
                gc.setFill(Color.rgb(entityColor.r(), entityColor.g(), entityColor.b()));
                gc.fillRect(j * size, i * size, size, size);
            }
        }
    }
}
