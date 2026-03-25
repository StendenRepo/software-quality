package nl.jabberpoint.memento;

import nl.jabberpoint.Slide;

import java.util.ArrayList;

public class PresentationMemento {
    private final String showTitle;
    private final ArrayList<Slide> showList;
    private final int currentSlideNumber;

    public PresentationMemento(String showTitle, ArrayList<Slide> showList, int currentSlideNumber) {
        this.showTitle = showTitle;
        this.showList = new ArrayList<>(showList);
        this.currentSlideNumber = currentSlideNumber;
    }

    public String getShowTitle() {
        return showTitle;
    }

    public ArrayList<Slide> getShowList() {
        return new ArrayList<>(showList);
    }

    public int getCurrentSlideNumber() {
        return currentSlideNumber;
    }
}
