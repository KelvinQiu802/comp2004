import model.Colors;
import model.WildCard;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Tests WildCard.
 * - Check if it can be used as part of any property set
 * - Check if it has no monetary value
 */
public class WildCardTest {
    private WildCard wildCard;

    @Test
    public void WildCard() {
        wildCard = new WildCard();
        assertEquals(Colors.ANY, wildCard.getCurrentColor());
        assertEquals(0,wildCard.getValue());
    }
}
