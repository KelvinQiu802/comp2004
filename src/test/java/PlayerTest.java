import controller.CardFactory;
import model.DrawPile;
import model.Player;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PlayerTest {
    private Player p1;
    private Player p2;
    private DrawPile pile;

    @BeforeEach
    public void init() {
        pile = new DrawPile(CardFactory.createCards());
        p1 = new Player("Kelvin");
        p2 = new Player("Jack");
    }

    @Test
    public void draw() {
        for (int i = 0; i < 5; i++) {
            p1.draw(pile);
            p2.draw(pile);
        }
        assertEquals(5, p1.getHandCards().size());
        assertEquals(5, p2.getHandCards().size());
    }
}
