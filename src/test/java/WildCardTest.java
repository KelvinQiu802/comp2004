import model.Colors;
import model.WildCard;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


public class WildCardTest {
    private WildCard wildCard;

    @Test
    public void alwaysAny(){
        wildCard=new WildCard("wildCard",2,"wildCard");
        assertEquals(Colors.ANY,wildCard.getCurrentColor());
    }
}
