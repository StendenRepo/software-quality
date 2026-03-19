package nl.jabberpoint;

import nl.jabberpoint.commands.*;

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
	private static final long serialVersionUID = 227L;

	private Frame parent; // het frame, alleen gebruikt als ouder voor de Dialogs
	private Presentation presentation; // Er worden commando's gegeven aan de presentatie

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

		Menu viewMenu = new Menu(VIEW);
		viewMenu.add(menuItem = mkMenuItem(NEXT));
		addCommand(menuItem, new NextSlideCommand(pres));

		viewMenu.add(menuItem = mkMenuItem(PREV));
		addCommand(menuItem, new PrevSlideCommand(pres));

		viewMenu.add(menuItem = mkMenuItem(GOTO));
		addCommand(menuItem, new GoToCommand(pres, frame));

		Menu helpMenu = new Menu(HELP);
		helpMenu.add(menuItem = mkMenuItem(ABOUT));
		addCommand(menuItem, new AboutCommand(frame));

		setHelpMenu(helpMenu);        // nodig for portability (Motif, etc.).
	}

	private void addCommand(MenuItem item, Command command) {
		item.addActionListener(e -> command.execute());
	}

	// een menu-item aanmaken
	public MenuItem mkMenuItem(String name) {
		return new MenuItem(name, new MenuShortcut(name.charAt(0)));
	}
}
