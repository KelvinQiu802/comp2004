import model.Colors;
import model.DoubleColorProperty;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


public class DoubleColorPropertyTest {
    private DoubleColorProperty doubleColorProperty;

    @Test
    public void switchCards() {
        doubleColorProperty = new DoubleColorProperty(1, Colors.BROWN, Colors.GREEN);
        assertEquals(Colors.BROWN, doubleColorProperty.getCurrentColor());
        doubleColorProperty.switchColor();
        assertEquals(Colors.GREEN, doubleColorProperty.getCurrentColor());
    }

}
