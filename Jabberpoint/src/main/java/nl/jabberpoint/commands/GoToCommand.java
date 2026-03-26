package nl.jabberpoint.commands;

import nl.jabberpoint.model.Presentation;
import nl.jabberpoint.memento.PresentationCaretaker;

import javax.swing.*;
import java.awt.*;

public class GoToCommand implements Command {

    private Presentation presentation;
    private PresentationCaretaker caretaker;
    private Frame parent;

    public GoToCommand(Presentation presentation, PresentationCaretaker caretaker, Frame parent) {
        this.presentation = presentation;
        this.caretaker = caretaker;
        this.parent = parent;
    }

    @Override
    public void execute() {
        String pageNumberStr = JOptionPane.showInputDialog(parent, "Page number?");

        if (pageNumberStr != null) {
            try {
                int pageNumber = Integer.parseInt(pageNumberStr);
                int newIndex = pageNumber - 1;

                // Alleen doorgaan als het nummer geldig is
                if (newIndex >= 0 && newIndex < presentation.getSize()) {

                    // Alleen opslaan als de slide echt verandert
                    if (newIndex != presentation.getSlideNumber()) {
                        caretaker.saveState(presentation); // 🔥 memento opslaan
                        presentation.setSlideNumber(newIndex);
                    }

                } else {
                    JOptionPane.showMessageDialog(parent,
                            "Slide does not exist",
                            "Error",
                            JOptionPane.ERROR_MESSAGE);
                }

            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(parent,
                        "Invalid number",
                        "Error",
                        JOptionPane.ERROR_MESSAGE);
            }
        }
    }
}