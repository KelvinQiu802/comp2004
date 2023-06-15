import model.*;
import model.actioncards.DealBreaker;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import view.PropertyDisplayView;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertSame;

/**
 * Tests the success of DealBreaker. - Steal a complete set of properties from any player - TODO
 */

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

    @BeforeAll
    public static void setInput() {
        String input = "0\n0\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
    }

    @Test
    public void testPlay() {
        PropertySet set1 = new PropertySet(Colors.GREEN);
        PropertyCard c1 = new SingleColorProperty("1", 1, Colors.GREEN);
        PropertyCard c2 = new SingleColorProperty("2", 2, Colors.GREEN);
        PropertyCard c3 = new SingleColorProperty("3", 3, Colors.GREEN);
        set1.add(c1);
        set1.add(c2);
        set1.add(c3);
        p1.getPropertyDeck().insertSet(set1);

        dealBreaker.play(p2, list);
        assertSame(p2.getPropertyDeck().getPropertySets().get(0), set1);
        PropertyDisplayView.printPropertyDeck(p2.getPropertyDeck());
    }
}