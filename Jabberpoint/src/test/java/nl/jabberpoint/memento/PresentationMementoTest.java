package nl.jabberpoint.memento;

import nl.jabberpoint.model.Slide;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.*;

public class PresentationMementoTest {

    @Test
    public void testConstructor() {
        ArrayList<Slide> slides = new ArrayList<>();
        Slide slide = Slide.builder().title("Test").build();
        slides.add(slide);

        PresentationMemento memento = new PresentationMemento("Test Title", slides, 0);

        assertEquals("Test Title", memento.getShowTitle());
        assertEquals(1, memento.getShowList().size());
        assertEquals(0, memento.getCurrentSlideNumber());
    }

    @Test
    public void testGetShowTitle() {
        PresentationMemento memento = new PresentationMemento("Title", new ArrayList<>(), 0);
        assertEquals("Title", memento.getShowTitle());
    }

    @Test
    public void testGetShowList() {
        ArrayList<Slide> slides = new ArrayList<>();
        Slide slide = Slide.builder().title("Test").build();
        slides.add(slide);

        PresentationMemento memento = new PresentationMemento("Title", slides, 0);
        ArrayList<Slide> retrievedSlides = memento.getShowList();

        assertEquals(1, retrievedSlides.size());
        assertNotSame(slides, retrievedSlides); // Should return a copy
    }

    @Test
    public void testGetCurrentSlideNumber() {
        PresentationMemento memento = new PresentationMemento("Title", new ArrayList<>(), 5);
        assertEquals(5, memento.getCurrentSlideNumber());
    }
}