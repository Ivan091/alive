package com.swing;

import com.domain.simulation.Simulation;
import com.domain.simulation.SimulationLive;
import com.domain.simulation.field.FieldLive;

import javax.swing.*;
import java.awt.*;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

public class Field extends Canvas {

    Simulation simulation = new SimulationLive(new FieldLive(320, 167));

    public static void main(String[] args) {
        JFrame frame = new JFrame();
        var c = new Field();
        frame.add(c);
        c.setBackground(Color.BLACK);
        frame.setBackground(Color.BLACK);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.pack();
        frame.setVisible(true);
        c.startGame();
    }

    private void startGame() {
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
