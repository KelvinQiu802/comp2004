import controller.Game;
import model.*;
import model.actioncards.DealBreaker;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import utils.Printer;
import view.PropertyDisplayView;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.sql.ClientInfoStatus;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class DealBreakerTest {
    private DealBreaker dealBreaker = new DealBreaker();
    Player p1;
    Player p2;
    List<Player> list = new ArrayList<Player>();

    @BeforeEach
    public void init() {
        p1 = new Player("A");
        p2 = new Player("B");
        list.add(p1);
        list.add(p2);
    }

    @Test
    public void testPlay() {
        DrawPile pile = new DrawPile(Printer.CardFactory.createCards());
        PropertySet set1 = new PropertySet(Colors.GREEN);
        PropertyCard c1 = new SingleColorProperty("1", 1, Colors.GREEN);
        PropertyCard c2 = new SingleColorProperty("2", 2, Colors.GREEN);
        PropertyCard c3 = new SingleColorProperty("3", 3, Colors.GREEN);
        set1.add(c1);
        set1.add(c2);
        set1.add(c3);
        p1.getPropertyDeck().insertSet(set1);
        // String input = "0\n";
        // InputStream in = new ByteArrayInputStream(input.getBytes());
        // System.setIn(in);
        dealBreaker.play(p2, list);
        assertSame(p2.getPropertyDeck().getPropertySets().get(0), set1);
        PropertyDisplayView.printPropertyDeck(p2.getPropertyDeck());
    }

    @Test
    public void testUnfilled() {
        DrawPile pile = new DrawPile(Printer.CardFactory.createCards());
        PropertySet set1 = new PropertySet(Colors.GREEN);
        PropertyCard c1 = new SingleColorProperty("1", 1, Colors.GREEN);
        PropertyCard c2 = new SingleColorProperty("2", 2, Colors.GREEN);
        set1.add(c1);
        set1.add(c2);
        p1.getPropertyDeck().insertSet(set1);
        dealBreaker.play(p2, list);
        assertSame(p2.getPropertyDeck().getPropertySets().get(0), set1);
        PropertyDisplayView.printPropertyDeck(p2.getPropertyDeck());
    }
}