package nl.jabberpoint.commands;

import nl.jabberpoint.model.Presentation;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class OpenCommandTest {

    @Test
    public void testExecute() {
        Presentation presentation = new Presentation();
        OpenCommand command = new OpenCommand(presentation, null);

        // Should load the test file without throwing exception
        assertDoesNotThrow(() -> command.execute());

        // Verify that presentation was loaded (should have slides)
        assertTrue(presentation.getSize() > 0);
    }
}