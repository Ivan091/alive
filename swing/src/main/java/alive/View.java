package alive;

import alive.simulation.SimulationField;
import org.springframework.stereotype.Component;
import javax.swing.*;
import java.awt.*;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;


@Component
public class View extends Canvas {

    private final SimulationField simulationField;

    public View(SimulationField simulationField) {
        this.simulationField = simulationField;
    }

    private void startGame() {
        JFrame frame = new JFrame();
        var c = new Field();
        frame.add(c);
        c.setBackground(Color.BLACK);
        frame.setBackground(Color.BLACK);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.pack();
        frame.setVisible(true);
        c.startGame();
        simulation.start();
        Executors.newScheduledThreadPool(4).scheduleAtFixedRate(() ->
                paint(getGraphics()), 0, 32, TimeUnit.MILLISECONDS);
        Executors.newScheduledThreadPool(4).scheduleWithFixedDelay(() ->
                IntStream.range(0, 100000).forEach(i -> simulation.nextMove()), 1000, 1, TimeUnit.MILLISECONDS);
    }

    @Override
    public void paint(Graphics g) {
        var ent = simulation.getField().cellsMatrix().getEntities();
        var yLen = ent.length;
        var xLen = ent[0].length;
        for (var i = 0; i < yLen; i++) {
            for (var j = 0; j < xLen; j++) {
                var entity = ent[i][j];
                g.setColor(entity.color());
                g.fillRect(j * 6, i * 6, 6, 6);
            }
        }
    }
}
