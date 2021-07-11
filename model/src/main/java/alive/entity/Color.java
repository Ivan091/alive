package alive.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;


@JsonSerialize(as = Color.class)
public interface Color {

    @JsonProperty("color")
    String toHex();

    Color remix(int dR, int dG, int dB);

    Color reset(int r, int g, int b);

    int r();

    int g();

    int b();
}
