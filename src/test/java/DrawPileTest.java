import model.AbstractCard;
import model.ActionCard;
import model.DrawPile;
import model.MoneyCard;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

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
        a1 = new ActionCard("Test", 10, "This is a test card");
        a2 = new ActionCard("Test", 20, "This is a test card");
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
    public  void takeCards(){
        pile.takeCards(4);
        assertEquals(4,pile.getUsingCards().size());
    }
}
