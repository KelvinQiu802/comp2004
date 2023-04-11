import model.AbstractCard;
import model.ActionCard;
import model.DrawPile;
import model.MoneyCard;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class DrawPileTest {
    private static DrawPile pile;
    private static MoneyCard m1;
    private static MoneyCard m2;
    private static ActionCard a1;
    private static ActionCard a2;


    @BeforeAll
    public static void createDrawPile() {
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
        assertEquals(4, pile.getUsingCard().size());
    }

    @Test
    public void removeCard() {
        AbstractCard removed = pile.take();
        assertEquals(m1, removed);
    }
}
