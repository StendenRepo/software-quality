package nl.jabberpoint.commands;

import nl.jabberpoint.model.Presentation;
import nl.jabberpoint.model.Slide;
import org.junit.jupiter.api.Test;
import java.awt.Frame;
import static org.junit.jupiter.api.Assertions.*;

public class NewCommandTest {

    @Test
    public void testExecute() {
        Presentation presentation = new Presentation();
        Slide slide = Slide.builder().title("Test").build();
        presentation.append(slide);
        presentation.setTitle("Test Title");
        presentation.setSlideNumber(0);

        Frame mockFrame = new MockFrame();
        NewCommand command = new NewCommand(presentation, mockFrame);

        command.execute();

        assertEquals(0, presentation.getSize());
        assertNull(presentation.getTitle());
        assertEquals(-1, presentation.getSlideNumber());
    }

    // Mock Frame class
    private static class MockFrame extends Frame {
        @Override
        public void repaint() {
            // Mock implementation
        }
    }
}