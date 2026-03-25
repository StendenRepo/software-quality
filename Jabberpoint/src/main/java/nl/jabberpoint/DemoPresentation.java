package nl.jabberpoint;

/** Een ingebouwde demo-presentatie
 * @author Ian F. Darwin, ian@darwinsys.com, Gert Florijn, Sylvia Stuurman
 * @version 1.1 2002/12/17 Gert Florijn
 * @version 1.2 2003/11/19 Sylvia Stuurman
 * @version 1.3 2004/08/17 Sylvia Stuurman
 * @version 1.4 2007/07/16 Sylvia Stuurman
 * @version 1.5 2010/03/03 Sylvia Stuurman
 * @version 1.6 2014/05/16 Sylvia Stuurman
 */

class DemoPresentation extends Accessor {

	public void loadFile(Presentation presentation, String unusedFilename) {
		presentation.setTitle("Demo Presentation");
		Slide slide;

		slide = Slide.builder("JabberPoint")
			.addText(1, "Het Java Presentatie Tool")
			.addText(2, "Copyright (c) 1996-2000: Ian Darwin")
			.addText(2, "Copyright (c) 2000-now:")
			.addText(2, "Gert Florijn en Sylvia Stuurman")
			.addText(4, "JabberPoint aanroepen zonder bestandsnaam")
			.addText(4, "laat deze presentatie zien")
			.addText(1, "Navigeren:").addText(3, "Volgende slide: PgDn of Enter")
			.addText(3, "Vorige slide: PgUp of up-arrow")
			.addText(3, "Stoppen: q or Q")
			.build();
		presentation.append(slide);

		slide = Slide.builder("Demonstratie van levels en stijlen")
			.addText(1, "Level 1")
			.addText(2, "Level 2")
			.addText(1, "Nogmaals level 1")
			.addText(1, "Level 1 heeft stijl nummer 1")
			.addText(2, "Level 2 heeft stijl nummer 2")
			.addText(3, "Zo ziet level 3 er uit")
			.addText(4, "En dit is level 4")
			.build();
		presentation.append(slide);

		slide = Slide.builder("De derde slide")
			.addText(1, "Om een nieuwe presentatie te openen,")
			.addText(2, "gebruik File->Open uit het menu.")
			.addText(1, " ")
			.addText(1, "Dit is het einde van de presentatie.")
			.addItem(new BitmapItem(1, "JabberPoint.jpg"))
			.build();
		presentation.append(slide);
	}

	public void saveFile(Presentation presentation, String unusedFilename) {
		throw new IllegalStateException("Save As->Demo! aangeroepen");
	}
}
