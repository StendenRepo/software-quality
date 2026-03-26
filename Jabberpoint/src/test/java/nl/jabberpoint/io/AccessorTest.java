package nl.jabberpoint.io;

import nl.jabberpoint.model.Presentation;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class AccessorTest {

    @Test
    public void testGetDemoAccessor() {
        Accessor accessor = Accessor.getDemoAccessor();
        assertNotNull(accessor);
        assertTrue(accessor instanceof DemoPresentation);
    }
}