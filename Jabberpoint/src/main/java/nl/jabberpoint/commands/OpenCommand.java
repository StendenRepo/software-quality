package nl.jabberpoint.commands;

import nl.jabberpoint.io.Accessor;
import nl.jabberpoint.controller.MenuController;
import nl.jabberpoint.model.Presentation;
import nl.jabberpoint.io.XMLAccessor;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class OpenCommand implements Command {
    private final Presentation presentation;
    private final Frame parent;

    public OpenCommand(Presentation presentation, Frame parent) {
        this.presentation = presentation;
        this.parent = parent;
    }

    @Override
    public void execute() {
        presentation.clear();
        Accessor xmlAccessor = new XMLAccessor();
        try {
            xmlAccessor.loadFile(presentation, MenuController.TESTFILE);
            presentation.setSlideNumber(0);
        } catch (IOException exception) {
            JOptionPane.showMessageDialog(parent,
                    MenuController.IOEX + exception,
                    MenuController.LOADERR,
                    JOptionPane.ERROR_MESSAGE);
        }
        parent.repaint();
    }
}
