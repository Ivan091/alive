package alive.entity;

import java.util.Objects;


public final class ColorDefault implements Color {

    private int r;

    private int g;

    private int b;

    public ColorDefault(int r, int g, int b) {
        reset(r, g, b);
    }

    @Override
    public int toRGB() {
        return r << 24 + g << 16 + b << 8 + 0xFF;
    }

    @Override
    public Color remix(int dR, int dG, int dB) {
        return reset(r + dR, g + dG, b + dB);
    }

    @Override
    public Color reset(int r, int g, int b) {
        this.r = makeInRange(r);
        this.g = makeInRange(g);
        this.b = makeInRange(b);
        return this;
    }

    @Override
    public Color replicate() {
        return new ColorDefault(r, g, b);
    }

    @Override
    public int r() {
        return r;
    }

    @Override
    public int g() {
        return g;
    }

    @Override
    public int b() {
        return b;
    }

    @Override
    public int hashCode() {
        return Objects.hash(r, g, b);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ColorDefault that = (ColorDefault) o;
        return r == that.r && g == that.g && b == that.b;
    }

    private int makeInRange(int x) {
        return Math.min(Math.max(x, 0), 225);
    }
}
