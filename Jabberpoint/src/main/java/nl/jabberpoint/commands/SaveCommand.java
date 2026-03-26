package nl.jabberpoint.commands;

import nl.jabberpoint.io.Accessor;
import nl.jabberpoint.model.Presentation;
import nl.jabberpoint.io.XMLAccessor;
import nl.jabberpoint.constants.FileIOConstants;
import nl.jabberpoint.constants.MessageConstants;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

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
            xmlAccessor.saveFile(presentation, FileIOConstants.SAVEFILE);
        } catch (IOException exc) {
            JOptionPane.showMessageDialog(parent, MessageConstants.IOEX + exc,
                    MessageConstants.SAVEERR, JOptionPane.ERROR_MESSAGE);
        }
    }
}
