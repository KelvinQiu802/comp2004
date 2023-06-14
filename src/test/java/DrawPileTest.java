import model.AbstractCard;
import model.ActionCard;
import model.DrawPile;
import model.MoneyCard;
import model.actioncards.DealBreaker;
import model.actioncards.Hotel;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Tests DrawPile.
 * - Create a new DrawPile
 * - Add card
 * - Take card
 */

public class DrawPileTest {
    private DrawPile pile;
    private MoneyCard m1;
    private MoneyCard m2;
    private ActionCard a1;
    private ActionCard a2;


    @BeforeEach
    public void createDrawPile() {
        m1 = new MoneyCard(1);
        m2 = new MoneyCard(5);
        a1 = new DealBreaker();
        a2 = new Hotel();
        List<AbstractCard> cards = new ArrayList<>();
        cards.add(m1);
        cards.add(m2);
        cards.add(a1);
        cards.add(a2);
        pile = new DrawPile(cards);
    }

    @Test
    public void addCard() {
        assertEquals(4, pile.getUsingCards().size());
    }

    @Test
    public void takeCards() {
        AbstractCard c1 = pile.takeCard();
        AbstractCard c2 = pile.takeCard();
        pile.add(c1);
        pile.add(c2);
        pile.takeCard();
        pile.takeCard();
        assertEquals(2, pile.getUsingCards().size());
    }
}
