import model.*;
import model.actioncards.ForcedDeal;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import view.PropertyDisplayView;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertSame;

/**
 * Tests the success of ForcedDeal. - Swap any property with another player
 * TODO- Cannot be a full set
 */
public class ForcedDealTest {
    private ForcedDeal forcedDeal = new ForcedDeal();
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
        PropertySet set1 = new PropertySet(Colors.GREEN);
        PropertyCard c1 = new SingleColorProperty("1", 1, Colors.GREEN);
        PropertySet set2 = new PropertySet(Colors.YELLOW);
        PropertyCard c2 = new SingleColorProperty("1", 1, Colors.YELLOW);
        set1.add(c1);
        set2.add(c2);
        p1.getPropertyDeck().insertSet(set1);
        p2.getPropertyDeck().insertSet(set2);

        String input = "0\n0\n0\n0\n0\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        forcedDeal.play(p2, list);
        assertSame(p2.getPropertyDeck().getPropertySets().get(0).getProperties().get(0), c1);
        assertSame(p1.getPropertyDeck().getPropertySets().get(0).getProperties().get(0), c2);
        PropertyDisplayView.printPropertyDeck(p1.getPropertyDeck());
        PropertyDisplayView.printPropertyDeck(p2.getPropertyDeck());
    }

//    @Test
//    public void fullSet() {
//        DrawPile pile = new DrawPile(Printer.CardFactory.createCards());
//        PropertySet set1 = new PropertySet(Colors.GREEN);
//        PropertyCard c1 = new SingleColorProperty("1", 1, Colors.GREEN);
//        PropertyCard c2 = new SingleColorProperty("2", 2, Colors.GREEN);
//        PropertyCard c3 = new SingleColorProperty("2", 2, Colors.GREEN);
//        set1.add(c1);
//        set1.add(c2);
//        set1.add(c3);
//        p1.getPropertyDeck().insertSet(set1);
//        forcedDeal.play(p2,list);
//        assertSame(p2.getPropertyDeck().getPropertySets().get(0), null);
//        PropertyDisplayView.printPropertyDeck(p2.getPropertyDeck());
//    }
}
