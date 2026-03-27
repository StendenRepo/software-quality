package nl.jabberpoint.commands;

import nl.jabberpoint.model.Presentation;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ExitCommandTest {

    @Test
    public void testConstructor() {
        Presentation presentation = new Presentation();
        ExitCommand command = new ExitCommand(presentation);
        assertNotNull(command);
    }

    // Note: execute() calls System.exit(0) which terminates the JVM,
    // so we don't test execute() directly in unit tests
}