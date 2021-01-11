package com.model.simulation.entities.qualities.color;

public class ColorEntity implements Color {

    private final ColorParameter red;
    private final ColorParameter green;
    private final ColorParameter blue;

    public ColorEntity(int r, int g, int b) {
        red = new ColorParameter(r);
        green = new ColorParameter(g);
        blue = new ColorParameter(b);
    }

    @Override
    public String toHexFormat() {
        return String.format("#%02x%02x%02x", red.colorParameter, green.colorParameter, blue.colorParameter);
    }

    @Override
    public void changeColor(int redIncrement, int greenIncrement, int blueIncrement) {
        red.increaseParameter(redIncrement);
        green.increaseParameter(greenIncrement);
        blue.increaseParameter(blueIncrement);
    }


    private static class ColorParameter {

        private int colorParameter;

        private ColorParameter(int colorParameter) {
            setParameter(colorParameter);
        }

        private void increaseParameter(int parameterIncrement) {
            setParameter(colorParameter + parameterIncrement);
        }

        private void setParameter(int newValue) {
            if (newValue < 0) {
                colorParameter = 0;
            } else {
                colorParameter = Math.min(newValue, 255);
            }
        }
    }
}