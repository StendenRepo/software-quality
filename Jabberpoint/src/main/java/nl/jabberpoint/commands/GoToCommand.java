package nl.jabberpoint.commands;

import nl.jabberpoint.Presentation;

import javax.swing.*;
import java.awt.*;

public class GoToCommand implements Command {

    private Presentation presentation;
    private Frame parent;

    public GoToCommand(Presentation presentation, Frame parent) {
        this.presentation = presentation;
        this.parent = parent;
    }

    @Override
    public void execute() {
        String pageNumberStr = JOptionPane.showInputDialog(parent, "Page number?");

        if (pageNumberStr != null) {
            try {
                int pageNumber = Integer.parseInt(pageNumberStr);
                presentation.setSlideNumber(pageNumber - 1);
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(parent,
                        "Invalid number",
                        "Error",
                        JOptionPane.ERROR_MESSAGE);
            }
        }
    }
}