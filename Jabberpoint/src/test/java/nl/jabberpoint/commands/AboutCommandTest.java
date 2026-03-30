package nl.jabberpoint.commands;

import nl.jabberpoint.view.AboutBox;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

public class AboutCommandTest {

    @Test
    public void testExecute() {
        try (MockedStatic<AboutBox> mockedAboutBox = Mockito.mockStatic(AboutBox.class)) {
            AboutCommand command = new AboutCommand(null);

            assertDoesNotThrow(command::execute);

            mockedAboutBox.verify(() -> AboutBox.show(null));
        }
    }
}