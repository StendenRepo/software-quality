package nl.jabberpoint.commands;

import nl.jabberpoint.model.Presentation;
import nl.jabberpoint.memento.PresentationCaretaker;

public class PrevSlideCommand implements Command {

    private Presentation presentation;
    private PresentationCaretaker caretaker;

    public PrevSlideCommand(Presentation presentation, PresentationCaretaker caretaker) {
        this.presentation = presentation;
        this.caretaker = caretaker;
    }

    @Override
    public void execute() {
        if (presentation.getSlideNumber() > 0) {
            caretaker.saveState(presentation);
            presentation.prevSlide();
        }
    }
}