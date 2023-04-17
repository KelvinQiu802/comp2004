import controller.Game;
import model.Player;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


public class ControllerTest {
    @BeforeEach
    public void createPlayer() {
        List<Player> players = Game.getPlayers();
        players.add(new Player("Kelvin"));
        players.add(new Player("Jack"));
    }

    @Test
    public void dealFiveCardsToAll() {
        List<Player> players = Game.getPlayers();
        Game.dealFiveCardsToAllPlayer();
        for (Player p : players) {
            assertEquals(5, p.getHandCards().size());
        }
    }
}
