package com.model.simulation.entities.qualities.color;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

public interface Color {

    @JsonProperty("color")
    String toHexFormat();

    @JsonIgnore
    int getR();

    void setR(int r);

    @JsonIgnore
    int getG();

    void setG(int g);

    @JsonIgnore
    int getB();

    void setB(int b);
}
