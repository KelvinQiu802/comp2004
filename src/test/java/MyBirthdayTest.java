import model.MoneyCard;
import model.Player;
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
    private List<Player> list = new ArrayList<Player>();

    @BeforeEach
    public void init() {
        p1 = new Player("A");
        p2 = new Player("B");
        p3 = new Player("C");
        list.add(p1);
        list.add(p2);
        list.add(p3);
        p1.putIntoBank(new MoneyCard(1));
        p1.putIntoBank(new MoneyCard(2));
        p1.putIntoBank(new MoneyCard(4));
        p1.putIntoBank(new MoneyCard(1));
    }

    @Test
    public void testPlay(){
        myBirthday.play(p3,list);
    }
}
