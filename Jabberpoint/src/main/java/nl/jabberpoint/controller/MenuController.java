package nl.jabberpoint.controller;

import nl.jabberpoint.commands.*;
import nl.jabberpoint.memento.PresentationCaretaker;

import nl.jabberpoint.model.Presentation;
import nl.jabberpoint.view.AboutBox;
import nl.jabberpoint.constants.UIConstants;
import nl.jabberpoint.constants.FileIOConstants;
import nl.jabberpoint.constants.MessageConstants;

import java.awt.*;

/**
 * <p>De controller voor het menu</p>
 *
 * @author Ian F. Darwin, ian@darwinsys.com, Gert Florijn, Sylvia Stuurman
 * @version 1.6 2014/05/16 Sylvia Stuurman
 */
public class MenuController extends MenuBar {

	private static final long serialVersionUID = 227L;

	public MenuController(Frame frame, Presentation pres) {
		MenuItem menuItem;

		Menu fileMenu = new Menu(UIConstants.FILE);
		fileMenu.add(menuItem = mkMenuItem(UIConstants.OPEN));
		addCommand(menuItem, new OpenCommand(pres, frame));
		fileMenu.add(menuItem = mkMenuItem(UIConstants.NEW));
		addCommand(menuItem, new NewCommand(pres, frame));
		fileMenu.add(menuItem = mkMenuItem(UIConstants.SAVE));
		addCommand(menuItem, new SaveCommand(pres, frame));

		fileMenu.addSeparator();

		fileMenu.add(menuItem = mkMenuItem(UIConstants.EXIT));
		addCommand(menuItem, new ExitCommand(pres));

		add(fileMenu);

		PresentationCaretaker caretaker = new PresentationCaretaker();
		Menu viewMenu = new Menu(UIConstants.VIEW);
		viewMenu.add(menuItem = mkMenuItem(UIConstants.NEXT));
		addCommand(menuItem, new NextSlideCommand(pres, caretaker));

		viewMenu.add(menuItem = mkMenuItem(UIConstants.PREV));
		addCommand(menuItem, new PrevSlideCommand(pres, caretaker));

		viewMenu.add(menuItem = mkMenuItem(UIConstants.UNDO));
		addCommand(menuItem, new UndoCommand(pres, caretaker));

		viewMenu.add(menuItem = mkMenuItem(UIConstants.REDO));
		addCommand(menuItem, new RedoCommand(pres, caretaker));

		viewMenu.add(menuItem = mkMenuItem(UIConstants.GOTO));
		addCommand(menuItem, new GoToCommand(pres,caretaker, frame));

		add(viewMenu);

		Menu helpMenu = new Menu(UIConstants.HELP);
		helpMenu.add(menuItem = mkMenuItem(UIConstants.ABOUT));
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
