import model.*;
import model.actioncards.MyBirthday;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

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

        PropertyCard c1 = new SingleColorProperty("1", 1, Colors.GREEN);
        PropertyCard c2 = new SingleColorProperty("2", 2, Colors.GREEN);
        PropertyCard c3 = new SingleColorProperty("3", 3, Colors.GREEN);
        p2.putIntoProperty(c1);
        p2.putIntoProperty(c2);
        p2.putIntoProperty(c3);
    }

    @Test
    public void testPlay(){
        myBirthday.play(p4,list);
    }
}
