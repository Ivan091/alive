package com;

import com.model.simulation.entities.alive.qualities.color.ColorEntity;

public class Test {
    public static void main(String[] args) {
        var cl = new ColorEntity(200, 200, 200);
        cl.incrementColor(-50, 50, -50);
        System.out.println(cl.toHexFormat());
        cl.incrementColor(-50, 50, -50);
        System.out.println(cl.toHexFormat());
        cl.incrementColor(-50, 50, -50);
        System.out.println(cl.toHexFormat());
        cl.incrementColor(-50, 50, -50);
        System.out.println(cl.toHexFormat());
    }
}
