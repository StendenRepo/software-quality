package nl.jabberpoint.commands;

import nl.jabberpoint.model.Presentation;
import nl.jabberpoint.memento.PresentationCaretaker;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class UndoCommandTest {

    @Test
    public void testExecute() {
        Presentation presentation = new Presentation();
        presentation.setTitle("Initial");

        PresentationCaretaker caretaker = new PresentationCaretaker();
        caretaker.saveState(presentation);

        presentation.setTitle("Modified");

        UndoCommand command = new UndoCommand(presentation, caretaker);
        command.execute();

        assertEquals("Initial", presentation.getTitle());
    }
}