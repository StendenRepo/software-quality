package nl.jabberpoint.commands;

import nl.jabberpoint.Presentation;

import java.awt.*;

public class NewCommand implements Command {
    private final Presentation presentation;
    private final Frame parent;

    public NewCommand(Presentation presentation, Frame parent) {
        this.presentation = presentation;
        this.parent = parent;
    }

    @Override
    public void execute() {
        presentation.clear();
        parent.repaint();
    }
}
