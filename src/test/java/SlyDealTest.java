import controller.Game;
import model.*;
import model.actioncards.DealBreaker;
import model.actioncards.ForcedDeal;
import model.actioncards.SlyDeal;
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

public class SlyDealTest {
    private SlyDeal slyDeal = new SlyDeal();
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
    public void testPlay(){
        PropertySet set1 = new PropertySet(Colors.YELLOW);
        PropertyCard c1 = new SingleColorProperty("1", 1, Colors.YELLOW);
        set1.add(c1);
        p1.getPropertyDeck().insertSet(set1);
        slyDeal.play(p2,list);
        assertSame(p2.getPropertyDeck().getPropertySets().get(0).getProperties().get(0), c1);
        PropertyDisplayView.printPropertyDeck(p1.getPropertyDeck());
        PropertyDisplayView.printPropertyDeck(p2.getPropertyDeck());
    }
}
