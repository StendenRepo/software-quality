package nl.jabberpoint.commands;

import nl.jabberpoint.model.Presentation;
import nl.jabberpoint.memento.PresentationCaretaker;

public class NextSlideCommand implements Command {

    private Presentation presentation;
    private PresentationCaretaker caretaker;

    public NextSlideCommand(Presentation presentation, PresentationCaretaker caretaker) {
        this.presentation = presentation;
        this.caretaker = caretaker;
    }

    @Override
    public void execute() {
        caretaker.saveState(presentation);
        presentation.nextSlide();
    }
}