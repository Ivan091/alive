package alive.entity;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


public class ColorDefaultTest {

    @Test
    void toHexWorksCyan() {
        var a = new ColorDefault(0, 255, 255);
        assertEquals("#00FFFF", a.toHex());
    }

    @Test
    void toHexWorksWhite() {
        var a = new ColorDefault(255, 255, 255);
        assertEquals("#FFFFFF", a.toHex());
    }
}