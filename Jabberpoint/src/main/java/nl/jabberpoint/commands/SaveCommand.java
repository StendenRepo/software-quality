package nl.jabberpoint.commands;

import nl.jabberpoint.io.Accessor;
import nl.jabberpoint.model.Presentation;
import nl.jabberpoint.io.XMLAccessor;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

import static nl.jabberpoint.controller.MenuController.*;

public class SaveCommand implements Command {
    private final Presentation presentation;
    private final Frame parent;

    public SaveCommand(Presentation presentation, Frame parent) {
        this.presentation = presentation;
        this.parent = parent;
    }

    @Override
    public void execute() {
        Accessor xmlAccessor = new XMLAccessor();
        try {
            xmlAccessor.saveFile(presentation, SAVEFILE);
        } catch (IOException exc) {
            JOptionPane.showMessageDialog(parent, IOEX + exc,
                    SAVEERR, JOptionPane.ERROR_MESSAGE);
        }
    }
}
