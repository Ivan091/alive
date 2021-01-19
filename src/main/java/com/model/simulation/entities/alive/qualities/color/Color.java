package com.model.simulation.entities.alive.qualities.color;

import com.fasterxml.jackson.annotation.JsonProperty;

public interface Color {

    @JsonProperty("color")
    String toHexFormat();

    void incrementColor(int redIncrement, int greenIncrement, int blueIncrement);
}
