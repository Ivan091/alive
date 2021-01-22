package com.domain.simulation.entities.alive.qualities.color;

import java.awt.Color;

public class ColorEntity implements com.domain.simulation.entities.alive.qualities.color.Color {

    private Color color;

    public ColorEntity(int red, int green, int blue) {
        setColor(red, green, blue);
    }

    public void setColor(int red, int green, int blue) {
        var r = validateColorParameter(red);
        var g = validateColorParameter(green);
        var b = validateColorParameter(blue);
        if (color == null || r != color.getRed() || g != color.getGreen() || b != color.getBlue()) {
            color = new Color(r, g, b);
        }
    }

    private int validateColorParameter(int colorParameter) {
        if (colorParameter < 0) {
            return 0;
        } else {
            return Math.min(colorParameter, 255);
        }
    }

    @Override
    public String toHexFormat() {
        return String.format("#%02x%02x%02x", color.getRed(), color.getGreen(), color.getBlue());
    }

    @Override
    public void incrementColor(int redIncrement, int greenIncrement, int blueIncrement) {
        setColor(
                color.getRed() + redIncrement,
                color.getGreen() + greenIncrement,
                color.getBlue() + blueIncrement
        );
    }

    @Override
    public Color color() {
        return color;
    }
}