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
        if (undoStack.isEmpty()) {
            return;
        }

        boolean matchesTop = isCurrentStateEqualTopMemento(presentation);
        redoStack.push(presentation.save());

        if (matchesTop) {
            undoStack.pop();
            if (!undoStack.isEmpty()) {
                presentation.restore(undoStack.peek());
            }
        } else {
            // Restore the top of the undo stack.
            presentation.restore(undoStack.pop());
        }
    }

    public void redo(Presentation presentation) {
        if (redoStack.isEmpty()) {
            return;
        }

        undoStack.push(presentation.save());
        presentation.restore(redoStack.pop());
    }

    private boolean isCurrentStateEqualTopMemento(Presentation presentation) {
        if (undoStack.isEmpty()) {
            return false;
        }

        PresentationMemento top = undoStack.peek();
        if (top == null) {
            return false;
        }

        String title = presentation.getTitle();
        if (title == null) {
            if (top.getShowTitle() != null) {
                return false;
            }
        } else if (!title.equals(top.getShowTitle())) {
            return false;
        }

        if (presentation.getSize() != top.getShowList().size()) {
            return false;
        }

        return presentation.getSlideNumber() == top.getCurrentSlideNumber();
    }
}
