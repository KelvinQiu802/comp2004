package model.actioncards;

import model.ActionCard;
import model.DrawPile;
import model.Player;

import java.util.List;

public class SlyDeal extends ActionCard {
    public SlyDeal() {
        super(ActionCardsName.SLY_DEAL, 3, "Steal a property from the player of your choice." +
                "(Cannot be part of a ful set.)");
    }

    @Override
    public void play(Player currentPlayer, List<Player> players, DrawPile pile) {

    }
}
