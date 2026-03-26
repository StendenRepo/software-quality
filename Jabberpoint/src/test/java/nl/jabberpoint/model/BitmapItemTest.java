package nl.jabberpoint.model;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.awt.Rectangle;
import static org.junit.jupiter.api.Assertions.*;

public class BitmapItemTest {

    @BeforeAll
    public static void setUp() {
        Style.createStyles();
    }

    @Test
    public void testConstructor() {
        BitmapItem item = new BitmapItem(1, "nonexistent.jpg");
        assertEquals(1, item.getLevel());
        assertEquals("nonexistent.jpg", item.getName());
        // bufferedImage will be null since file doesn't exist
    }

    @Test
    public void testDefaultConstructor() {
        BitmapItem item = new BitmapItem();
        assertEquals(0, item.getLevel());
        assertNull(item.getName());
    }

    @Test
    public void testGetName() {
        BitmapItem item = new BitmapItem(0, "test.jpg");
        assertEquals("test.jpg", item.getName());
    }

    @Test
    public void testGetBoundingBoxWithNullImage() {
        BitmapItem item = new BitmapItem(0, "nonexistent.jpg");
        Style style = Style.getStyle(0);
        BufferedImage img = new BufferedImage(100, 100, BufferedImage.TYPE_INT_RGB);
        Graphics g = img.getGraphics();

        // This might throw NPE because bufferedImage is null
        // In real usage, we'd have a valid image
        assertThrows(NullPointerException.class, () -> {
            item.getBoundingBox(g, null, 1.0f, style);
        });
    }

    @Test
    public void testDrawWithNullImage() {
        BitmapItem item = new BitmapItem(0, "nonexistent.jpg");
        Style style = Style.getStyle(0);
        BufferedImage img = new BufferedImage(100, 100, BufferedImage.TYPE_INT_RGB);
        Graphics g = img.getGraphics();

        // This might throw NPE
        assertThrows(NullPointerException.class, () -> {
            item.draw(0, 0, 1.0f, g, style, null);
        });
    }

    @Test
    public void testToString() {
        BitmapItem item = new BitmapItem(1, "test.jpg");
        assertEquals("BitmapItem[1,test.jpg]", item.toString());
    }
}