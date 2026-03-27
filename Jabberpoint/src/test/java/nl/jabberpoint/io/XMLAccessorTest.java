package nl.jabberpoint.io;

import nl.jabberpoint.model.Presentation;
import org.junit.jupiter.api.Test;
import java.io.IOException;
import static org.junit.jupiter.api.Assertions.*;

public class XMLAccessorTest {

    @Test
    public void testLoadFile() throws IOException {
        Presentation presentation = new Presentation();
        XMLAccessor accessor = new XMLAccessor();

        java.net.URL resource = getClass().getClassLoader().getResource("test.xml");
        assertNotNull(resource, "test.xml resource not found in classpath");

        accessor.loadFile(presentation, resource.getFile());

        assertNotNull(presentation.getTitle());
        assertTrue(presentation.getSize() > 0);
    }

    @Test
    public void testSaveFile() throws IOException {
        Presentation presentation = new Presentation();
        presentation.setTitle("Test Presentation");
        // Add a slide to save
        nl.jabberpoint.model.Slide slide = nl.jabberpoint.model.Slide.builder()
                .title("Test Slide")
                .addText(1, "Test text")
                .build();
        presentation.append(slide);

        XMLAccessor accessor = new XMLAccessor();

        // Should save without exception
        assertDoesNotThrow(() -> accessor.saveFile(presentation, "test_output.xml"));
    }
}