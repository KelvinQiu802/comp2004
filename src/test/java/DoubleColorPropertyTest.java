import model.Colors;
import model.DoubleColorProperty;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Tests the success of DoubleColorProperty. - Switch the Double Color Property Card's color.
 */
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
