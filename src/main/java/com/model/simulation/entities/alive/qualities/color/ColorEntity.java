package com.model.simulation.entities.alive.qualities.color;

public class ColorEntity implements Color {

    private int color;

    public ColorEntity(int red, int green, int blue) {
        setColor(red, green, blue);
    }

    @Override
    public String toHexFormat() {
        return String.format("#%08x", color);
    }

    @Override
    public void incrementColor(int redIncrement, int greenIncrement, int blueIncrement) {
        setColor(
                (color >>> 24 & 255) + redIncrement,
                (color >>> 16 & 255) + greenIncrement,
                (color >>> 8 & 255) + blueIncrement
        );
    }

    public void setColor(int red, int green, int blue) {
        color = 255;
        color += validateColorParameter(red) << 24;
        color += validateColorParameter(green) << 16;
        color += validateColorParameter(blue) << 8;
    }

    private int validateColorParameter(int colorParameter) {
        if (colorParameter < 0) {
            return 0;
        } else {
            return Math.min(colorParameter, 255);
        }
    }
}