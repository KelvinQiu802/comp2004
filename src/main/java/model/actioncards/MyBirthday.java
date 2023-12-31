package model.actioncards;

import model.ActionCard;
import model.Player;

import java.util.ArrayList;
import java.util.List;

public class MyBirthday extends ActionCard {
    public MyBirthday() {
        super(ActionCardsName.ITS_MY_BIRTHDAY, 2, "All players give you 2M as a gift.");
    }

    @Override
    public void play(Player currentPlayer, List<Player> players) {
        List<Player> others = new ArrayList<>();
        for(Player player : players){
            others.add(player);
        }
        others.remove(currentPlayer);
        for (Player p : others) {
            p.payTo(currentPlayer, 2);
        }
    }
}
