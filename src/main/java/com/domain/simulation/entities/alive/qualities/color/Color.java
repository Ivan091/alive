package com.domain.simulation.entities.alive.qualities.color;

import com.fasterxml.jackson.annotation.JsonProperty;

public interface Color {

    @JsonProperty("color")
    String toHexFormat();

    void incrementColor(int redIncrement, int greenIncrement, int blueIncrement);

    java.awt.Color color();
}
