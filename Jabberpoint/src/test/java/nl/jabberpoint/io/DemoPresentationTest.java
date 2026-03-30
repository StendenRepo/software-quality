package nl.jabberpoint.io;

import nl.jabberpoint.model.Presentation;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class DemoPresentationTest {

    @Test
    public void testLoadFile() {
        Presentation presentation = new Presentation();
        DemoPresentation demo = new DemoPresentation();

        demo.loadFile(presentation, "");

        assertEquals("Demo Presentation", presentation.getTitle());
        assertEquals(3, presentation.getSize()); // Should have 3 slides
    }

    @Test
    public void testSaveFileThrowsException() {
        Presentation presentation = new Presentation();
        DemoPresentation demo = new DemoPresentation();

        IllegalStateException exception = assertThrows(IllegalStateException.class, () -> {
            demo.saveFile(presentation, "");
        });

        assertEquals("Save As->Demo! aangeroepen", exception.getMessage());
    }
}