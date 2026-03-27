package nl.jabberpoint.controller;

import nl.jabberpoint.model.Presentation;
import nl.jabberpoint.model.Slide;
import org.junit.jupiter.api.Test;
import java.awt.event.KeyEvent;
import static org.junit.jupiter.api.Assertions.*;

public class KeyControllerTest {

    @Test
    public void testConstructor() {
        Presentation presentation = new Presentation();
        KeyController controller = new KeyController(presentation);
        assertNotNull(controller);
    }

    @Test
    public void testKeyPressedPageDown() {
        Presentation presentation = new Presentation();
        Slide slide1 = Slide.builder().title("Slide 1").build();
        Slide slide2 = Slide.builder().title("Slide 2").build();
        presentation.append(slide1);
        presentation.append(slide2);
        presentation.setSlideNumber(0);

        KeyController controller = new KeyController(presentation);

        // Simulate PAGE_DOWN key
        KeyEvent event = new KeyEvent(new java.awt.Component() {}, KeyEvent.KEY_PRESSED, System.currentTimeMillis(), 0, KeyEvent.VK_PAGE_DOWN, (char) 0);
        controller.keyPressed(event);

        assertEquals(1, presentation.getSlideNumber());
    }

    @Test
    public void testKeyPressedPageUp() {
        Presentation presentation = new Presentation();
        Slide slide1 = Slide.builder().title("Slide 1").build();
        Slide slide2 = Slide.builder().title("Slide 2").build();
        presentation.append(slide1);
        presentation.append(slide2);
        presentation.setSlideNumber(1);

        KeyController controller = new KeyController(presentation);

        // Simulate PAGE_UP key
        KeyEvent event = new KeyEvent(new java.awt.Component() {}, KeyEvent.KEY_PRESSED, System.currentTimeMillis(), 0, KeyEvent.VK_PAGE_UP, (char) 0);
        controller.keyPressed(event);

        assertEquals(0, presentation.getSlideNumber());
    }

    // Note: Testing 'q' or 'Q' would call System.exit(0), which terminates the JVM
    // So we don't test that in unit tests
}