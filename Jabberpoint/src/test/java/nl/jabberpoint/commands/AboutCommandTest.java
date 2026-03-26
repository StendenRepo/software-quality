package nl.jabberpoint.commands;

import org.junit.jupiter.api.Test;
import java.awt.Frame;
import static org.junit.jupiter.api.Assertions.*;

public class AboutCommandTest {

    @Test
    public void testExecute() {
        Frame mockFrame = new Frame();
        AboutCommand command = new AboutCommand(mockFrame);

        // Should not throw exception
        assertDoesNotThrow(() -> command.execute());
    }
}