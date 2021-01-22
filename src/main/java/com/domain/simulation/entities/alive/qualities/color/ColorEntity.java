package com.domain.simulation.entities.alive.qualities.color;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.jackson.ColorEntitySerializer;

import java.awt.*;

@JsonSerialize(using = ColorEntitySerializer.class)
public class ColorEntity extends Color {

    public ColorEntity(int red, int green, int blue) {
        super(red, green, blue);
    }

    @JsonProperty
    public String toHexFormat() {
        return String.format("#%02x%02x%02x", getRed(), getGreen(), getBlue());
    }

    public ColorEntity incrementValue(int redIncrement, int greenIncrement, int blueIncrement) {
        return setColor(
                getRed() + redIncrement,
                getGreen() + greenIncrement,
                getBlue() + blueIncrement
        );
    }

    public ColorEntity setColor(int red, int green, int blue) {
        var r = validateColorParameter(red);
        var g = validateColorParameter(green);
        var b = validateColorParameter(blue);
        if (r != getRed() || g != getGreen() || b != getBlue()) {
            return new ColorEntity(r, g, b);
        }
        return this;
    }

    private int validateColorParameter(int colorParameter) {
        if (colorParameter < 0) {
            return 0;
        } else {
            return Math.min(colorParameter, 255);
        }
    }
}