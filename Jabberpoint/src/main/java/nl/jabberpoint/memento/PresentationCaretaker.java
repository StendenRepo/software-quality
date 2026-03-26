package nl.jabberpoint.memento;

import nl.jabberpoint.model.Presentation;

import java.util.Stack;

public class PresentationCaretaker {
    private Stack<PresentationMemento> undoStack = new Stack<>();
    private Stack<PresentationMemento> redoStack = new Stack<>();

    public void saveState(Presentation presentation) {
        undoStack.push(presentation.save());
        redoStack.clear();
    }

    public void undo(Presentation presentation) {
        if (!undoStack.isEmpty()) {
            redoStack.push(presentation.save());
            presentation.restore(undoStack.pop());
        }
    }

    public void redo(Presentation presentation) {
        if (!redoStack.isEmpty()) {
            undoStack.push(presentation.save());
            presentation.restore(redoStack.pop());
        }
    }
}
