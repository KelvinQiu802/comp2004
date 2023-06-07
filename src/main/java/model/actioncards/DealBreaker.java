package model.actioncards;

import model.ActionCard;
import model.DrawPile;
import model.Player;

import java.util.List;

public class DealBreaker extends ActionCard {
    public DealBreaker() {
        super(ActionCardsName.DEAL_BREAKER, 5, "Steal a complete set of properties from any player. " +
                "(Includes any buildings.)");
    }

    @Override
    public void play(Player currentPlayer, List<Player> players, DrawPile pile) {

    }
}
