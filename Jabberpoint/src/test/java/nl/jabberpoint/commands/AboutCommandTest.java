package nl.jabberpoint.commands;

import org.junit.jupiter.api.Test;
import java.awt.GraphicsEnvironment;
import java.awt.HeadlessException;
import static org.junit.jupiter.api.Assertions.*;

public class AboutCommandTest {

    @Test
    public void testExecute() {
        AboutCommand command = new AboutCommand(null);

        if (GraphicsEnvironment.isHeadless()) {
            assertThrows(HeadlessException.class, command::execute);
        } else {
            assertDoesNotThrow(command::execute);
        }
    }
}