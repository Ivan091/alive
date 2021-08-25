package alive.swing;

import alive.config.SimulationFactory;
import alive.simulation.Simulation;
import org.springframework.stereotype.Component;
import java.awt.*;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;


@Component
public class Field extends Canvas {

    private static final int W = 317;

    private static final int H = 165;

    private static final int SIZE = 6;

    private final Simulation simulation;

    public Field(SimulationFactory factory) {
        simulation = factory.create(W, H);
        this.setSize(W * SIZE, H * SIZE);
        this.setBackground(Color.BLACK);
    }

    public void startGame() {
        Executors.newScheduledThreadPool(1).scheduleWithFixedDelay(() ->
                paint(getGraphics()), 0, 32, TimeUnit.MILLISECONDS);
        Executors.newScheduledThreadPool(1).scheduleWithFixedDelay(simulation::update, 1000000, 10, TimeUnit.MICROSECONDS);
    }

    @Override
    public void paint(Graphics g) {
        var state = simulation.state();
        for (var y = 0; y < H; y++) {
            for (var x = 0; x < W; x++) {
                var entity = state[y][x];
                var entityColor = entity.color();
                var color = new Color(entityColor.r(), entityColor.g(), entityColor.b());
                g.setColor(color);
                g.fillRect(x * SIZE, y * SIZE, SIZE, SIZE);
            }
        }
    }
}
