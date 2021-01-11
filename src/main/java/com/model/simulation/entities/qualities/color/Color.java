package com.model.simulation.entities.qualities.color;

import com.fasterxml.jackson.annotation.JsonProperty;

public interface Color {

    @JsonProperty("color")
    String toHexFormat();

    void changeColor(int redIncrement, int greenIncrement, int blueIncrement);
}
