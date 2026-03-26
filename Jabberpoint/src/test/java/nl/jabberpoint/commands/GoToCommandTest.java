package nl.jabberpoint.commands;

import nl.jabberpoint.model.Presentation;
import nl.jabberpoint.model.Slide;
import nl.jabberpoint.memento.PresentationCaretaker;
import org.junit.jupiter.api.Test;
import java.awt.Frame;
import static org.junit.jupiter.api.Assertions.*;

public class GoToCommandTest {

    @Test
    public void testConstructor() {
        Presentation presentation = new Presentation();
        PresentationCaretaker caretaker = new PresentationCaretaker();
        Frame parent = new Frame();
        GoToCommand command = new GoToCommand(presentation, caretaker, parent);
        assertNotNull(command);
    }

    // Note: execute() uses JOptionPane.showInputDialog which requires user interaction,
    // so we don't test execute() directly in unit tests
}