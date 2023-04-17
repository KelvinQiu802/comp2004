import controller.CardFactory;
import model.AbstractCard;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class CardFactoryTest {
    @Test
    public void createCards() {
        List<AbstractCard> cards = CardFactory.createCards();
        assertEquals(106, cards.size());
    }
}
