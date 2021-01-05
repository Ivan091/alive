package com.model.simulation.entities.qualities.color;

public class ColorEntity implements Color {

    private int r;
    private int g;
    private int b;

    public ColorEntity(int r, int g, int b) {
        this.r = r;
        this.g = g;
        this.b = b;
    }

    @Override
    public int getR() {
        return r;
    }

    public void setR(int r) {
        this.r = validateColorComponentLimits(r);
    }

    @Override
    public int getG() {
        return g;
    }

    public void setG(int g) {
        this.g = validateColorComponentLimits(g);
    }

    @Override
    public int getB() {
        return b;
    }

    public void setB(int b) {
        this.b = validateColorComponentLimits(b);
    }

    private int validateColorComponentLimits(int colorComponent) {
        if (colorComponent < 0) {
            return 0;
        } else if (colorComponent > 255) {
            return 255;
        } else {
            return colorComponent;
        }
    }
}