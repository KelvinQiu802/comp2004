import model.MoneyCard;
import model.Player;
import model.actioncards.DebtCollector;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertSame;

/**
 * Tests the success of DebtCollector. - Choose one player to pay 5M
 */
public class DebtCollectorTest {
    private DebtCollector debtCollector = new DebtCollector();
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
    public void testPlay() {
        String input = "0\n0\n0\n0\n1\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        debtCollector.play(p3, list);
        int value = 0;
        for (int i = 0; i < p3.getBank().getBankCards().size(); i++) {
            value = value + p3.getBank().getBankCards().get(i).getValue();
        }
        assertSame(value, 5);
    }
}
