package nl.jabberpoint.commands;

import nl.jabberpoint.model.Presentation;
import nl.jabberpoint.model.Slide;
import nl.jabberpoint.memento.PresentationCaretaker;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class NextSlideCommandTest {

    @Test
    public void testExecute() {
        Presentation presentation = new Presentation();
        Slide slide1 = Slide.builder().title("Slide 1").build();
        Slide slide2 = Slide.builder().title("Slide 2").build();
        presentation.append(slide1);
        presentation.append(slide2);
        presentation.setSlideNumber(0);

        PresentationCaretaker caretaker = new PresentationCaretaker();
        NextSlideCommand command = new NextSlideCommand(presentation, caretaker);

        command.execute();

        assertEquals(1, presentation.getSlideNumber());
    }

    @Test
    public void testExecuteAtLastSlide() {
        Presentation presentation = new Presentation();
        Slide slide = Slide.builder().title("Slide 1").build();
        presentation.append(slide);
        presentation.setSlideNumber(0);

        PresentationCaretaker caretaker = new PresentationCaretaker();
        NextSlideCommand command = new NextSlideCommand(presentation, caretaker);

        command.execute();

        // Should stay at last slide
        assertEquals(0, presentation.getSlideNumber());
    }
}