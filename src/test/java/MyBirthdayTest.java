import model.*;
import model.actioncards.MyBirthday;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/***
 * Tests the success of MyBirthday. - Every player pay 2M
 */
public class MyBirthdayTest {
    private MyBirthday myBirthday = new MyBirthday();
    private Player p1;
    private Player p2;
    private Player p3;
    private Player p4;
    private List<Player> list = new ArrayList<Player>();

    @BeforeEach
    public void init() {
        p1 = new Player("A");
        p2 = new Player("B");
        p3 = new Player("C");
        p4 = new Player("D");
        list.add(p1);
        list.add(p2);
        list.add(p3);
        list.add(p4);
        p1.putIntoBank(new MoneyCard(1));
        p1.putIntoBank(new MoneyCard(2));
        p1.putIntoBank(new MoneyCard(4));
        p1.putIntoBank(new MoneyCard(1));

        PropertySet set = new PropertySet(Colors.GREEN);
        PropertyCard c1 = new SingleColorProperty("1", 1, Colors.GREEN);
        PropertyCard c2 = new SingleColorProperty("2", 2, Colors.GREEN);
        PropertyCard c3 = new SingleColorProperty("3", 3, Colors.GREEN);

        set.add(c1);
        set.add(c2);
        set.add(c3);

        p2.getPropertyDeck().insertSet(set);
    }

    @Test
    public void testPlay() {
        String input = "0\n1\n1\n1\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        myBirthday.play(p4, list);
    }
}
