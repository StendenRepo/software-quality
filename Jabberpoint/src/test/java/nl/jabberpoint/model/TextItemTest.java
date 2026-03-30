package nl.jabberpoint.model;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.awt.Rectangle;
import static org.junit.jupiter.api.Assertions.*;

public class TextItemTest {

    @BeforeAll
    public static void setUp() {
        Style.createStyles();
    }

    @Test
    public void testConstructor() {
        TextItem item = new TextItem(1, "Test Text");
        assertEquals(1, item.getLevel());
        assertEquals("Test Text", item.getText());
    }

    @Test
    public void testDefaultConstructor() {
        TextItem item = new TextItem();
        assertEquals(0, item.getLevel());
        assertEquals("No Text Given", item.getText());
    }

    @Test
    public void testGetText() {
        TextItem item = new TextItem(0, "Hello");
        assertEquals("Hello", item.getText());

        TextItem nullItem = new TextItem(0, null);
        assertEquals("", nullItem.getText());
    }

    @Test
    public void testGetAttributedString() {
        TextItem item = new TextItem(0, "Test");
        Style style = Style.getStyle(0);
        var attrStr = item.getAttributedString(style, 1.0f);
        assertNotNull(attrStr);
    }

    @Test
    public void testGetBoundingBox() {
        TextItem item = new TextItem(0, "Test");
        Style style = Style.getStyle(0);
        BufferedImage img = new BufferedImage(100, 100, BufferedImage.TYPE_INT_RGB);
        Graphics g = img.getGraphics();

        Rectangle bbox = item.getBoundingBox(g, null, 1.0f, style);
        assertNotNull(bbox);
        assertTrue(bbox.width >= 0);
        assertTrue(bbox.height >= 0);
    }

    @Test
    public void testDraw() {
        TextItem item = new TextItem(0, "Test");
        Style style = Style.getStyle(0);
        BufferedImage img = new BufferedImage(100, 100, BufferedImage.TYPE_INT_RGB);
        Graphics g = img.getGraphics();

        // Should not throw exception
        item.draw(0, 0, 1.0f, g, style, null);
    }

    @Test
    public void testDrawEmptyText() {
        TextItem item = new TextItem(0, "");
        Style style = Style.getStyle(0);
        BufferedImage img = new BufferedImage(100, 100, BufferedImage.TYPE_INT_RGB);
        Graphics g = img.getGraphics();

        // Should not throw exception
        item.draw(0, 0, 1.0f, g, style, null);
    }

    @Test
    public void testToString() {
        TextItem item = new TextItem(1, "Test");
        assertEquals("TextItem[1,Test]", item.toString());
    }
}