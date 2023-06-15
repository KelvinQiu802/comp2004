import model.*;
import model.actioncards.JustSayNo;
import model.actioncards.MyBirthday;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/***
 * Test the success of JustSayNo. -Disabling the action card.
 */

public class JustSayNoTest {
    private JustSayNo justSayNo = new JustSayNo();
    private MyBirthday myBirthday = new MyBirthday();
    private Player p1;
    private Player p2;
    private MoneyCard m1 = new MoneyCard(2);
    private MoneyCard m2 = new MoneyCard(7);
    private MoneyCard m3 = new MoneyCard(3);
    private MoneyCard m4 = new MoneyCard(4);
    private List<Player> list = new ArrayList<Player>();

    @BeforeEach
    public void init() {
        // Create two players
        p1 = new Player("A");
        p2 = new Player("B");

        list.add(p1);
        list.add(p2);

        // Give the money to p1
        p1.putIntoBank(m1);
        p1.putIntoBank(m2);
        p1.putIntoBank(m3);
        p1.putIntoBank(m4);

        // Give green properties to p2
        PropertySet set = new PropertySet(Colors.GREEN);
        PropertyCard c1 = new SingleColorProperty("1", 1, Colors.GREEN);
        PropertyCard c2 = new SingleColorProperty("2", 2, Colors.GREEN);
        PropertyCard c3 = new SingleColorProperty("3", 3, Colors.GREEN);
        set.add(c1);
        set.add(c2);
        set.add(c3);
        p2.getPropertyDeck().insertSet(set);

        // Give just say no card to p1
        p1.getHandCards().add(justSayNo);
    }

    @Test
    public void testPlay() {
        String input = "1\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        myBirthday.play(p2, list);
    }
}
