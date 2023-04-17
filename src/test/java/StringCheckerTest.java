import org.junit.jupiter.api.Test;
import view.StringChecker;

import static org.junit.jupiter.api.Assertions.*;

public class StringCheckerTest {
    @Test
    public void isInteger() {
        assertTrue(StringChecker.isInteger("1001"));
        assertTrue(StringChecker.isInteger("0"));
        assertTrue(StringChecker.isInteger("99"));
        assertTrue(StringChecker.isInteger("-11"));
    }

    @Test
    public void isNotInteger() {
        assertFalse(StringChecker.isInteger("Hello"));
        assertFalse(StringChecker.isInteger(".11"));
        assertFalse(StringChecker.isInteger(""));
        assertFalse(StringChecker.isInteger("  "));
    }
}
