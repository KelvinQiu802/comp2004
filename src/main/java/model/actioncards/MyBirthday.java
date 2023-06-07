package model.actioncards;

import controller.Game;
import model.ActionCard;
import model.Player;

import java.util.List;

public class MyBirthday extends ActionCard {
    public MyBirthday() {
        super(ActionCardsName.ITS_MY_BIRTHDAY, 2, "All players give you 2M as a gift.");
    }

    @Override
    public void play(Player currentPlayer) {
        List<Player> players = Game.getPlayers();
        for (Player p : players) {
            if (p == currentPlayer) continue;
            p.payTo(currentPlayer, 2);
        }
    }
}
