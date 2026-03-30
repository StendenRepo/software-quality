package nl.jabberpoint.model;

import nl.jabberpoint.memento.PresentationMemento;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PresentationTest {

    @Test
    public void testConstructor() {
        Presentation presentation = new Presentation();
        assertEquals(0, presentation.getSize());
        assertNull(presentation.getTitle());
        assertEquals(-1, presentation.getSlideNumber());
    }

    @Test
    public void testConstructorWithViewer() {
        Presentation presentation = new Presentation();
        // Can't test with viewer since it's private, but constructor exists
        assertNotNull(presentation);
    }

    @Test
    public void testGetSize() {
        Presentation presentation = new Presentation();
        assertEquals(0, presentation.getSize());

        Slide slide = Slide.builder().title("Test").build();
        presentation.append(slide);
        assertEquals(1, presentation.getSize());
    }

    @Test
    public void testGetTitle() {
        Presentation presentation = new Presentation();
        assertNull(presentation.getTitle());

        presentation.setTitle("Test Presentation");
        assertEquals("Test Presentation", presentation.getTitle());
    }

    @Test
    public void testSetTitle() {
        Presentation presentation = new Presentation();
        presentation.setTitle("New Title");
        assertEquals("New Title", presentation.getTitle());
    }

    @Test
    public void testSetShowView() {
        Presentation presentation = new Presentation();
        // Can't test since field is private
        presentation.setShowView(null);
    }

    @Test
    public void testGetSlideNumber() {
        Presentation presentation = new Presentation();
        assertEquals(-1, presentation.getSlideNumber());
    }

    @Test
    public void testSetSlideNumber() {
        Presentation presentation = new Presentation();
        Slide slide = Slide.builder().title("Test").build();
        presentation.append(slide);

        presentation.setSlideNumber(0);
        assertEquals(0, presentation.getSlideNumber());

        // Test bounds
        presentation.setSlideNumber(-1);
        assertEquals(0, presentation.getSlideNumber());

        presentation.setSlideNumber(10);
        assertEquals(0, presentation.getSlideNumber()); // only one slide
    }

    @Test
    public void testSetSlideNumberEmptyPresentation() {
        Presentation presentation = new Presentation();
        presentation.setSlideNumber(0);
        assertEquals(-1, presentation.getSlideNumber());
    }

    @Test
    public void testPrevSlide() {
        Presentation presentation = new Presentation();
        Slide slide1 = Slide.builder().title("Slide 1").build();
        Slide slide2 = Slide.builder().title("Slide 2").build();
        presentation.append(slide1);
        presentation.append(slide2);

        presentation.setSlideNumber(1);
        presentation.prevSlide();
        assertEquals(0, presentation.getSlideNumber());

        // Already at first slide
        presentation.prevSlide();
        assertEquals(0, presentation.getSlideNumber());
    }

    @Test
    public void testNextSlide() {
        Presentation presentation = new Presentation();
        Slide slide1 = Slide.builder().title("Slide 1").build();
        Slide slide2 = Slide.builder().title("Slide 2").build();
        presentation.append(slide1);
        presentation.append(slide2);

        presentation.setSlideNumber(0);
        presentation.nextSlide();
        assertEquals(1, presentation.getSlideNumber());

        // Already at last slide
        presentation.nextSlide();
        assertEquals(1, presentation.getSlideNumber());
    }

    @Test
    public void testClear() {
        Presentation presentation = new Presentation();
        Slide slide = Slide.builder().title("Test").build();
        presentation.append(slide);
        presentation.setTitle("Test Title");
        presentation.setSlideNumber(0);

        presentation.clear();

        assertEquals(0, presentation.getSize());
        assertNull(presentation.getTitle());
        assertEquals(-1, presentation.getSlideNumber());
    }

    @Test
    public void testAppend() {
        Presentation presentation = new Presentation();
        Slide slide = Slide.builder().title("Test").build();
        presentation.append(slide);

        assertEquals(1, presentation.getSize());
        assertEquals(slide, presentation.getSlide(0));
    }

    @Test
    public void testGetSlide() {
        Presentation presentation = new Presentation();
        Slide slide = Slide.builder().title("Test").build();
        presentation.append(slide);

        assertEquals(slide, presentation.getSlide(0));
        assertNull(presentation.getSlide(-1));
        assertNull(presentation.getSlide(1));
    }

    @Test
    public void testGetCurrentSlide() {
        Presentation presentation = new Presentation();
        Slide slide = Slide.builder().title("Test").build();
        presentation.append(slide);
        presentation.setSlideNumber(0);

        assertEquals(slide, presentation.getCurrentSlide());
    }

    @Test
    public void testSaveAndRestore() {
        Presentation presentation = new Presentation();
        Slide slide = Slide.builder().title("Test Slide").build();
        presentation.append(slide);
        presentation.setTitle("Test Presentation");
        presentation.setSlideNumber(0);

        PresentationMemento memento = presentation.save();

        // Modify presentation
        presentation.setTitle("Modified");
        presentation.clear();

        // Restore
        presentation.restore(memento);

        assertEquals("Test Presentation", presentation.getTitle());
        assertEquals(1, presentation.getSize());
        assertEquals(0, presentation.getSlideNumber());
    }

    @Test
    public void testRestoreWithNullMemento() {
        Presentation presentation = new Presentation();
        presentation.setTitle("Original");

        presentation.restore(null);

        assertEquals("Original", presentation.getTitle());
    }
}