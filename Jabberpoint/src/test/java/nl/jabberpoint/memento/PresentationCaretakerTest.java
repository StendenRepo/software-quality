package nl.jabberpoint.memento;

import nl.jabberpoint.model.Presentation;
import nl.jabberpoint.model.Slide;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PresentationCaretakerTest {

    @Test
    public void testSaveState() {
        PresentationCaretaker caretaker = new PresentationCaretaker();
        Presentation presentation = new Presentation();
        Slide slide = Slide.builder().title("Test").build();
        presentation.append(slide);
        presentation.setTitle("Test Title");

        caretaker.saveState(presentation);

        // Verify state is saved (internal test)
        // Since stacks are private, we test through undo/redo
    }

    @Test
    public void testUndo() {
        PresentationCaretaker caretaker = new PresentationCaretaker();
        Presentation presentation = new Presentation();

        // Initial state
        presentation.setTitle("Initial");

        // Save initial state
        caretaker.saveState(presentation);

        // Modify
        presentation.setTitle("Modified");

        // Undo
        caretaker.undo(presentation);

        assertEquals("Initial", presentation.getTitle());
    }

    @Test
    public void testRedo() {
        PresentationCaretaker caretaker = new PresentationCaretaker();
        Presentation presentation = new Presentation();

        // Initial state
        presentation.setTitle("Initial");

        // Save initial state
        caretaker.saveState(presentation);

        // Modify
        presentation.setTitle("Modified");

        // Undo
        caretaker.undo(presentation);
        assertEquals("Initial", presentation.getTitle());

        // Redo
        caretaker.redo(presentation);
        assertEquals("Modified", presentation.getTitle());
    }

    @Test
    public void testUndoWithEmptyStack() {
        PresentationCaretaker caretaker = new PresentationCaretaker();
        Presentation presentation = new Presentation();
        presentation.setTitle("Original");

        caretaker.undo(presentation);

        // Should remain unchanged
        assertEquals("Original", presentation.getTitle());
    }

    @Test
    public void testRedoWithEmptyStack() {
        PresentationCaretaker caretaker = new PresentationCaretaker();
        Presentation presentation = new Presentation();
        presentation.setTitle("Original");

        caretaker.redo(presentation);

        // Should remain unchanged
        assertEquals("Original", presentation.getTitle());
    }

    @Test
    public void testSaveStateClearsRedoStack() {
        PresentationCaretaker caretaker = new PresentationCaretaker();
        Presentation presentation = new Presentation();

        // Initial state
        presentation.setTitle("Initial");
        caretaker.saveState(presentation);

        // Modify and save
        presentation.setTitle("Modified");
        caretaker.saveState(presentation);

        // Undo to initial
        caretaker.undo(presentation);
        assertEquals("Initial", presentation.getTitle());

        // Try redo - should not work since redo stack was cleared
        caretaker.redo(presentation);
        assertEquals("Initial", presentation.getTitle()); // Should stay the same
    }
}