package nl.jabberpoint.model;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.util.Vector;
import static org.junit.jupiter.api.Assertions.*;

public class SlideTest {

    @BeforeAll
    public static void setUp() {
        Style.createStyles();
    }

    @Test
    public void testConstructor() {
        Slide slide = new Slide();
        assertNotNull(slide.getSlideItems());
        assertEquals(0, slide.getSize());
    }

    @Test
    public void testBuilder() {
        Slide slide = Slide.builder()
                .title("Test Slide")
                .addText(0, "Title")
                .addText(1, "Bullet 1")
                .build();

        assertEquals("Test Slide", slide.getTitle());
        assertEquals(2, slide.getSize());
        assertTrue(slide.getSlideItem(0) instanceof TextItem);
        assertTrue(slide.getSlideItem(1) instanceof TextItem);
    }

    @Test
    public void testAppend() {
        Slide slide = new Slide();
        TextItem item = new TextItem(0, "Test");
        slide.append(item);

        assertEquals(1, slide.getSize());
        assertEquals(item, slide.getSlideItem(0));
    }

    @Test
    public void testAppendWithLevelAndMessage() {
        Slide slide = new Slide();
        slide.append(1, "Test Message");

        assertEquals(1, slide.getSize());
        TextItem item = (TextItem) slide.getSlideItem(0);
        assertEquals(1, item.getLevel());
        assertEquals("Test Message", item.getText());
    }

    @Test
    public void testGetTitle() {
        Slide slide = new Slide();
        assertNull(slide.getTitle());

        slide.setTitle("New Title");
        assertEquals("New Title", slide.getTitle());
    }

    @Test
    public void testSetTitle() {
        Slide slide = new Slide();
        slide.setTitle("Test Title");
        assertEquals("Test Title", slide.getTitle());
    }

    @Test
    public void testGetSlideItem() {
        Slide slide = new Slide();
        TextItem item = new TextItem(0, "Test");
        slide.append(item);

        assertEquals(item, slide.getSlideItem(0));
    }

    @Test
    public void testGetSlideItems() {
        Slide slide = new Slide();
        Vector<SlideItem> items = slide.getSlideItems();
        assertNotNull(items);
        assertEquals(0, items.size());
    }

    @Test
    public void testGetSize() {
        Slide slide = new Slide();
        assertEquals(0, slide.getSize());

        slide.append(new TextItem(0, "Test"));
        assertEquals(1, slide.getSize());
    }

    @Test
    public void testDraw() {
        Slide slide = Slide.builder()
                .title("Test Slide")
                .addText(0, "Title")
                .build();

        BufferedImage img = new BufferedImage(1200, 800, BufferedImage.TYPE_INT_RGB);
        Graphics g = img.getGraphics();
        Rectangle area = new Rectangle(0, 0, 1200, 800);

        // Should not throw exception
        slide.draw(g, area, null);
    }

    @Test
    public void testConstants() {
        assertEquals(1200, Slide.WIDTH);
        assertEquals(800, Slide.HEIGHT);
    }
}