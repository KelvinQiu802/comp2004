package model.actioncards;

import model.ActionCard;
import model.DrawPile;
import model.Player;

import java.util.List;

public class DebtCollector extends ActionCard {
    public DebtCollector() {
        super(ActionCardsName.DEBT_COLLECTOR, 3, "Force any player to pay you 5M");
    }

    @Override
    public void play(Player currentPlayer, List<Player> players, DrawPile pile) {

    }
}
