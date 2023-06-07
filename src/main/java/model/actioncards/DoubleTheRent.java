package model.actioncards;

import model.ActionCard;
import model.DrawPile;
import model.Player;

import java.util.List;

public class DoubleTheRent extends ActionCard {
    public DoubleTheRent() {
        super(ActionCardsName.DOUBLE_THE_RENT, 1, "Needs to be played with a rent card.");
    }

    @Override
    public void play(Player currentPlayer, List<Player> players, DrawPile pile) {

    }
}
