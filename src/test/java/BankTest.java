import model.ActionCard;
import model.Bank;
import model.MoneyCard;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BankTest {
    private static Bank bank;
    private static MoneyCard m1;
    private static MoneyCard m2;
    private static ActionCard a1;
    private static ActionCard a2;

    @BeforeAll
    public static void createBank() {
        bank = new Bank();
        m1 = new MoneyCard(1);
        m2 = new MoneyCard(5);
        a1 = new ActionCard("Test", 10, "This is a test card");
        a2 = new ActionCard("Test", 20, "This is a test card");
    }

    @Test
    public void addCard() {
        bank.add(m1);
        bank.add(m2);
        bank.add(a1);
        bank.add(a2);

        assertEquals(4, bank.getBankCards().size());
    }

    @Test
    public void removeCard() {
        bank.remove(m1);

        assertEquals(3, bank.getBankCards().size());
        assertFalse(bank.getBankCards().contains(m1));
    }
}
