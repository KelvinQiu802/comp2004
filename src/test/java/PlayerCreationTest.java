import org.junit.jupiter.api.Test;
import view.PlayerCreationView;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

public class PlayerCreationTest {
    @Test
    public void inputNumber() {
        String input = "5\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        int number = PlayerCreationView.getNumberOfPlayer();
        assertEquals(5, number);
    }

    @Test
    public void invalidInputNumber() {
        String input = "abc\n10\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        int number = PlayerCreationView.getNumberOfPlayer();
        assertEquals(10, number);
    }

    @Test
    public void inputName() {
        String input = "Kelvin\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        String name = PlayerCreationView.getPlayerName();
        assertEquals("Kelvin", name);
    }

    @Test
    public void invalidInputName() {
        String input = " \nSkye\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        String name = PlayerCreationView.getPlayerName();
        assertEquals("Skye", name);
    }
}
