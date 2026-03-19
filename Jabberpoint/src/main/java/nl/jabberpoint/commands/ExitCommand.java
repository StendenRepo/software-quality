package nl.jabberpoint.commands;

import nl.jabberpoint.Presentation;

public class ExitCommand implements Command {
    private final Presentation presentation;

    public ExitCommand(Presentation presentation) {
        this.presentation = presentation;
    }

    @Override
    public void execute() {
        presentation.exit(0);
    }
}
