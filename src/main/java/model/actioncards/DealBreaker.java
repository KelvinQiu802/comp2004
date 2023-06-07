package model.actioncards;

import model.ActionCard;
import model.Player;

public class DealBreaker extends ActionCard {
    public DealBreaker() {
        super(ActionCardsName.DEAL_BREAKER, 5, "Steal a complete set of properties from any player. " +
                "(Includes any buildings.)");
    }

    @Override
    public void play(Player currentPlayer) {

    }
}
