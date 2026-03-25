package nl.jabberpoint;

import nl.jabberpoint.commands.*;
import nl.jabberpoint.memento.PresentationCaretaker;

import java.awt.*;

/**
 * <p>De controller voor het menu</p>
 *
 * @author Ian F. Darwin, ian@darwinsys.com, Gert Florijn, Sylvia Stuurman
 * @version 1.6 2014/05/16 Sylvia Stuurman
 */
public class MenuController extends MenuBar {

	//	Vraag of dit public moet of private en dan mee geven aan addcommand?
	public static final String ABOUT = "About";
	public static final String FILE = "File";
	public static final String EXIT = "Exit";
	public static final String GOTO = "Go to";
	public static final String HELP = "Help";
	public static final String NEW = "New";
	public static final String NEXT = "Next";
	public static final String OPEN = "Open";
	public static final String PAGENR = "Page number?";
	public static final String PREV = "Prev";
	public static final String SAVE = "Save";
	public static final String VIEW = "View";
	public static final String TESTFILE = "test.xml";
	public static final String SAVEFILE = "dump.xml";
	public static final String IOEX = "IO Exception: ";
	public static final String LOADERR = "Load Error";
	public static final String SAVEERR = "Save Error";
	public static final String UNDO = "Undo";
	public static final String REDO = "Redo";
	private static final long serialVersionUID = 227L;

	public MenuController(Frame frame, Presentation pres) {
		MenuItem menuItem;

		Menu fileMenu = new Menu(FILE);
		fileMenu.add(menuItem = mkMenuItem(OPEN));
		addCommand(menuItem, new OpenCommand(pres, frame));
		fileMenu.add(menuItem = mkMenuItem(NEW));
		addCommand(menuItem, new NewCommand(pres, frame));
		fileMenu.add(menuItem = mkMenuItem(SAVE));
		addCommand(menuItem, new SaveCommand(pres, frame));

		fileMenu.addSeparator();

		fileMenu.add(menuItem = mkMenuItem(EXIT));
		addCommand(menuItem, new ExitCommand(pres));

		add(fileMenu);

		PresentationCaretaker caretaker = new PresentationCaretaker();
		Menu viewMenu = new Menu(VIEW);
		viewMenu.add(menuItem = mkMenuItem(NEXT));
		addCommand(menuItem, new NextSlideCommand(pres, caretaker));

		viewMenu.add(menuItem = mkMenuItem(PREV));
		addCommand(menuItem, new PrevSlideCommand(pres, caretaker));

		viewMenu.add(menuItem = mkMenuItem(UNDO));
		addCommand(menuItem, new UndoCommand(pres, caretaker));

		viewMenu.add(menuItem = mkMenuItem(REDO));
		addCommand(menuItem, new RedoCommand(pres, caretaker));

		viewMenu.add(menuItem = mkMenuItem(GOTO));
		addCommand(menuItem, new GoToCommand(pres,caretaker, frame));

		add(viewMenu);

		Menu helpMenu = new Menu(HELP);
		helpMenu.add(menuItem = mkMenuItem(ABOUT));
		addCommand(menuItem, new AboutCommand(frame));

		setHelpMenu(helpMenu);        // nodig for portability (Motif, etc.).
	}

	//	Invoker
	private void addCommand(MenuItem item, Command command) {
		item.addActionListener(e -> command.execute());
	}

	// een menu-item aanmaken
	public MenuItem mkMenuItem(String name) {
		return new MenuItem(name, new MenuShortcut(name.charAt(0)));
	}
}
