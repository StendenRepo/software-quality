package nl.jabberpoint.commands;

import nl.jabberpoint.AboutBox;

import java.awt.*;

public class AboutCommand implements Command {

    private Frame parent;

    public AboutCommand(Frame parent) {
        this.parent = parent;
    }

    @Override
    public void execute() {
        AboutBox.show(parent);
    }
}
