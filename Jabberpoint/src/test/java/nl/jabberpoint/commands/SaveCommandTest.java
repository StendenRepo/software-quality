package nl.jabberpoint.commands;

import nl.jabberpoint.model.Presentation;
import nl.jabberpoint.model.Slide;
import org.junit.jupiter.api.Test;
import java.awt.Frame;
import static org.junit.jupiter.api.Assertions.*;

public class SaveCommandTest {

    @Test
    public void testExecute() {
        Presentation presentation = new Presentation();
        Slide slide = Slide.builder().title("Test Slide").build();
        presentation.append(slide);
        presentation.setTitle("Test Presentation");

        Frame mockFrame = new Frame();
        SaveCommand command = new SaveCommand(presentation, mockFrame);

        // Should save without throwing exception
        assertDoesNotThrow(() -> command.execute());
    }
}