package alive.entity;

public class ColorRGB implements Color {

    private int r;

    private int g;

    private int b;

    public ColorRGB(int r, int g, int b) {
        reset(r, g, b);
    }

    @Override
    public String toHex() {
        return String.format("#%02X%02X%02X", r, g, b);
    }

    @Override
    public void remix(int dR, int dG, int dB) {
        reset(r + dR, g + dG, b + dB);
    }

    @Override
    public void reset(int r, int g, int b) {
        this.r = makeInRange(r);
        this.g = makeInRange(g);
        this.b = makeInRange(b);
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

    private int makeInRange(int x) {
        return Math.min(Math.max(x, 0), 255);
    }
}
