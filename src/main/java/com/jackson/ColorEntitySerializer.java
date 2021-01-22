package com.jackson;

import com.domain.simulation.entities.alive.qualities.color.ColorEntity;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

import java.io.IOException;

public class ColorEntitySerializer extends StdSerializer<ColorEntity> {
    public ColorEntitySerializer() {
        this(null);
    }

    protected ColorEntitySerializer(Class<ColorEntity> t) {
        super(t);
    }

    @Override
    public void serialize(ColorEntity value, JsonGenerator gen, SerializerProvider provider) throws IOException {
        gen.writeString(value.toHexFormat());
    }
}
