package alive.entity;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


class ColorRGBTest {

    @Test
    void toHexWorksCyan() {
        var a = new ColorRGB(0, 255, 255);
        assertEquals("#00FFFF", a.toHex());
    }

    @Test
    void toHexWorksWhite() {
        var a = new ColorRGB(255, 255, 255);
        assertEquals("#FFFFFF", a.toHex());
    }
}