package nl.jabberpoint.commands;

import nl.jabberpoint.model.Presentation;
import nl.jabberpoint.memento.PresentationCaretaker;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class RedoCommandTest {

    @Test
    public void testExecute() {
        Presentation presentation = new Presentation();
        presentation.setTitle("Initial");

        PresentationCaretaker caretaker = new PresentationCaretaker();
        caretaker.saveState(presentation);

        presentation.setTitle("Modified");
        caretaker.saveState(presentation);

        presentation.setTitle("Further Modified");

        // Undo twice
        caretaker.undo(presentation);
        caretaker.undo(presentation);

        // Redo
        RedoCommand command = new RedoCommand(presentation, caretaker);
        command.execute();

        assertEquals("Modified", presentation.getTitle());
    }
}