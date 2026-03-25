package nl.jabberpoint.commands;

import nl.jabberpoint.Presentation;
import nl.jabberpoint.memento.PresentationCaretaker;

public class RedoCommand implements Command {
    private Presentation presentation;
    private PresentationCaretaker caretaker;

    public RedoCommand(Presentation presentation, PresentationCaretaker caretaker) {
        this.presentation = presentation;
        this.caretaker = caretaker;
    }

    @Override
    public void execute() {
        caretaker.redo(presentation);
    }
}
