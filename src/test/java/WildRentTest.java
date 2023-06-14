import model.*;
import model.actioncards.WildRent;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

public class WildRentTest {
    private WildRent wildRent = new WildRent();
    private Player p1;
    private Player p2;
    private MoneyCard m1=new MoneyCard(2);
    private MoneyCard m2=new MoneyCard(7);
    private MoneyCard m3=new MoneyCard(3);
    private MoneyCard m4=new MoneyCard(4);
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

        // Give  green properties to p2
        PropertyCard c1 = new SingleColorProperty("1", 1, Colors.GREEN);
        PropertyCard c2 = new SingleColorProperty("2", 2, Colors.GREEN);
        PropertyCard c3 = new SingleColorProperty("3", 3, Colors.GREEN);
        p2.putIntoProperty(c1);
        p2.putIntoProperty(c2);
        p2.putIntoProperty(c3);
    }

    @Test
    public void testPlay(){
        wildRent.play(p2,list);
        // After p1 give $2 and $7 to p2, judge if p2 has $2 and $7
        assertTrue(p2.getBank().getBankCards().get(0).getValue()==2);
        assertTrue(p2.getBank().getBankCards().get(1).getValue()==7);

        // After p1 give $2 and $7 to p2, judge if p1 only has $3 and $4
        assertTrue(p1.getBank().getBankCards().get(0).getValue()==3);
        assertTrue(p1.getBank().getBankCards().get(1).getValue()==4);
    }
}
