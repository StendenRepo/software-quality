package nl.jabberpoint.commands;

import nl.jabberpoint.io.Accessor;
import nl.jabberpoint.model.Presentation;
import nl.jabberpoint.io.XMLAccessor;
import nl.jabberpoint.constants.FileIOConstants;
import nl.jabberpoint.constants.MessageConstants;

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
            xmlAccessor.loadFile(presentation, FileIOConstants.TESTFILE);
            presentation.setSlideNumber(0);
        } catch (IOException exception) {
            JOptionPane.showMessageDialog(parent,
                    MessageConstants.IOEX + exception,
                    MessageConstants.LOADERR,
                    JOptionPane.ERROR_MESSAGE);
        }
        if (parent != null) {
            parent.repaint();
        }
    }
}
