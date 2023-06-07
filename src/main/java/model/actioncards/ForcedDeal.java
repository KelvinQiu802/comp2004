package model.actioncards;

import model.ActionCard;
import model.Player;

public class ForcedDeal extends ActionCard {
    public ForcedDeal() {
        super(ActionCardsName.FORCED_DEAL, 3, "Swap any property with another player." +
                "(Cannot be part of a full set.)");
    }

    @Override
    public void play(Player currentPlayer) {

    }
}
