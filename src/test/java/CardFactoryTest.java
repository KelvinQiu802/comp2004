import model.AbstractCard;
import org.junit.jupiter.api.Test;
import utils.Printer;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CardFactoryTest {
    @Test
    public void createCards() {
        List<AbstractCard> cards = Printer.CardFactory.createCards();
        assertEquals(108, cards.size());
    }
}
