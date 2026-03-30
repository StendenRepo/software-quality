package nl.jabberpoint.model;

import nl.jabberpoint.memento.PresentationMemento;
import nl.jabberpoint.view.SlideViewerComponent;

import java.util.ArrayList;

/**
 * <p>Presentation houdt de slides in de presentatie bij.</p>
 * <p>Er is slechts één instantie van deze klasse aanwezig.</p>
 * @author Ian F. Darwin, ian@darwinsys.com, Gert Florijn, Sylvia Stuurman
 * @version 1.1 2002/12/17 Gert Florijn
 * @version 1.2 2003/11/19 Sylvia Stuurman
 * @version 1.3 2004/08/17 Sylvia Stuurman
 * @version 1.4 2007/07/16 Sylvia Stuurman
 * @version 1.5 2010/03/03 Sylvia Stuurman
 * @version 1.6 2014/05/16 Sylvia Stuurman
 */
public class Presentation {
	private String showTitle; // de titel van de presentatie
	private ArrayList<Slide> showList = null; // een ArrayList met de Slides
	private int currentSlideNumber = 0; // het slidenummer van de huidige Slide
	private SlideViewerComponent slideViewComponent = null; // de viewcomponent voor de Slides

	public Presentation() {
		slideViewComponent = null;
		clear();
	}

	public Presentation(SlideViewerComponent slideViewerComponent) {
		this.slideViewComponent = slideViewerComponent;
		clear();
	}

	public int getSize() {
		return showList.size();
	}

	public String getTitle() {
		return showTitle;
	}

	public void setTitle(String nt) {
		showTitle = nt;
	}

	public void setShowView(SlideViewerComponent slideViewerComponent) {
		this.slideViewComponent = slideViewerComponent;
	}

	// geef het nummer van de huidige slide
	public int getSlideNumber() {
		return currentSlideNumber;
	}

	// verander het huidige-slide-nummer en laat het aan het window weten
	public void setSlideNumber(int number) {
		if (showList.isEmpty()) {
			currentSlideNumber = -1;
		} else if (number < 0) {
			currentSlideNumber = 0;
		} else if (number >= showList.size()) {
			currentSlideNumber = showList.size() - 1;
		} else {
			currentSlideNumber = number;
		}

		if (slideViewComponent != null) {
			slideViewComponent.update(this, getCurrentSlide());
		}
	}

	// ga naar de vorige slide tenzij je aan het begin van de presentatie bent
	public void prevSlide() {
		if (currentSlideNumber > 0) {
			setSlideNumber(currentSlideNumber - 1);
		}
	}

	// ga naar de volgende slide tenzij je aan het einde van de presentatie bent
	public void nextSlide() {
		if (currentSlideNumber < (showList.size() - 1)) {
			setSlideNumber(currentSlideNumber + 1);
		}
	}

	// verwijder de presentatie, om klaar te zijn voor de volgende
	public void clear() {
		showTitle = null;
		showList = new ArrayList<Slide>();
		currentSlideNumber = -1;

		if (slideViewComponent != null) {
			slideViewComponent.update(this, getCurrentSlide());
		}
	}

	// voeg een slide toe aan de presentatie
	public void append(Slide slide) {
		showList.add(slide);

		if (currentSlideNumber == -1) {
			setSlideNumber(0);
		}
	}

	// geef een slide met een bepaald slidenummer
	public Slide getSlide(int number) {
		if (number < 0 || number >= getSize()) {
			return null;
		}
		return showList.get(number);
	}

	// geef de huidige Slide
	public Slide getCurrentSlide() {
		return getSlide(currentSlideNumber);
	}

	public void exit(int n) {
		System.exit(n);
	}

	public PresentationMemento save() {
		return new PresentationMemento(showTitle, new ArrayList<>(showList), currentSlideNumber);
	}

	public void restore(PresentationMemento memento) {
		if (memento == null) {
			return;
		}

		this.showTitle = memento.getShowTitle();
		this.showList = new ArrayList<>(memento.getShowList());
		this.currentSlideNumber = memento.getCurrentSlideNumber();

		if (slideViewComponent != null) {
			slideViewComponent.update(this, getCurrentSlide());
		}
	}
}
