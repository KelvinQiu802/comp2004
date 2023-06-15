import org.junit.jupiter.api.*;
import view.PlayerInputView;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Tests PlayerCreation. - Get the numbers and names of players - Check the type of input
 */
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class PlayerCreationTest {
    @BeforeAll
    public static void setInput() {
        String input = "5\nabc\n10\nKelvin\nSkye\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
    }

    @Test
    @Order(1)
    public void inputNumber() {
        int number = PlayerInputView.getNumberOfPlayer();
        assertEquals(5, number);
    }

    @Test
    @Order(2)
    public void invalidInputNumber() {
        int number = PlayerInputView.getNumberOfPlayer();
        assertEquals(10, number);
    }

    @Test
    @Order(3)
    public void inputName() {
        String name = PlayerInputView.getPlayerName();
        assertEquals("Kelvin", name);
    }

    @Test
    @Order(4)
    public void invalidInputName() {
        String name = PlayerInputView.getPlayerName();
        assertEquals("Skye", name);
    }
}
