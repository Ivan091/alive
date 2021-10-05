package alive.entity;

public interface Color {

    Color remix(int dR, int dG, int dB);

    Color reset(int r, int g, int b);

    Color replicate();

    int r();

    int g();

    int b();
}
