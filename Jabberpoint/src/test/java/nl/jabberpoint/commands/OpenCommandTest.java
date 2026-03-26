package nl.jabberpoint.commands;

import nl.jabberpoint.model.Presentation;
import org.junit.jupiter.api.Test;
import java.awt.Frame;
import static org.junit.jupiter.api.Assertions.*;

public class OpenCommandTest {

    @Test
    public void testExecute() {
        Presentation presentation = new Presentation();
        Frame mockFrame = new Frame();
        OpenCommand command = new OpenCommand(presentation, mockFrame);

        // Should load the test file without throwing exception
        assertDoesNotThrow(() -> command.execute());

        // Verify that presentation was loaded (should have slides)
        assertTrue(presentation.getSize() > 0);
    }
}