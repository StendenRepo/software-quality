package nl.jabberpoint.model;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import java.awt.Color;
import java.awt.Font;
import static org.junit.jupiter.api.Assertions.*;

public class StyleTest {

    @BeforeAll
    public static void setUp() {
        Style.createStyles();
    }

    @Test
    public void testCreateStyles() {
        Style style0 = Style.getStyle(0);
        assertNotNull(style0);
        assertEquals(Color.red, style0.color);
        assertEquals(48, style0.fontSize);

        Style style1 = Style.getStyle(1);
        assertEquals(Color.blue, style1.color);
        assertEquals(40, style1.fontSize);

        Style style4 = Style.getStyle(4);
        assertEquals(Color.black, style4.color);
        assertEquals(24, style4.fontSize);
    }

    @Test
    public void testGetStyle() {
        Style style = Style.getStyle(0);
        assertNotNull(style);

        // Test out of bounds
        Style styleOutOfBounds = Style.getStyle(10);
        assertEquals(Style.getStyle(4), styleOutOfBounds);
    }

    @Test
    public void testStyleConstructor() {
        Style style = new Style(10, Color.green, 32, 15);
        assertEquals(10, style.indent);
        assertEquals(Color.green, style.color);
        assertEquals(32, style.fontSize);
        assertEquals(15, style.leading);
        assertNotNull(style.font);
    }

    @Test
    public void testGetFont() {
        Style style = new Style(0, Color.black, 24, 10);
        Font font = style.getFont(1.0f);
        assertNotNull(font);
        assertEquals(24.0f, font.getSize2D());

        Font scaledFont = style.getFont(2.0f);
        assertEquals(48.0f, scaledFont.getSize2D());
    }

    @Test
    public void testToString() {
        Style style = new Style(20, Color.blue, 40, 10);
        String expected = "[20,java.awt.Color[r=0,g=0,b=255]; 40 on 10]";
        assertEquals(expected, style.toString());
    }
}